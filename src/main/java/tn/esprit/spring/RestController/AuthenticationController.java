package tn.esprit.spring.RestController;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.DAO.Entities.Login;
import tn.esprit.spring.DAO.Repository.LoginRepository;
import tn.esprit.spring.DAO.dto.AuthenticationRequest;
import tn.esprit.spring.DAO.dto.AuthenticationResponse;
import tn.esprit.spring.utils.JwtUtil;

import java.io.IOException;
import java.util.Optional;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private LoginRepository loginRepository;
    public static final String TOKEN_PREFIX ="Bearer";

    public static final String HEADER_STRING ="Authorization";

    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));

    } catch (BadCredentialsException e){
        throw new BadCredentialsException("Incorrect Username or password");
    } catch (DisabledException disabledException){
        response.sendError(HttpServletResponse.SC_NOT_FOUND,"User is Not Created");
        return ;
    }
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
    Optional<Login> optionalUser = loginRepository.findFirstByEmail(userDetails.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());

    if(optionalUser.isPresent()){
        response.getWriter().write(new JSONObject()
                .put("userId",optionalUser.get().getId())
                .put("role",optionalUser.get().getRole())
                .toString());
    }

    response.setHeader("Access-Control-Expose-Headers","Authorization");
    response.setHeader("Access-Control-Allow-Headers","Authorization,X-Pingother,Origin,X-requested-With,Content-Type,Accept,X-Custom-Header");
    response.setHeader(HEADER_STRING,TOKEN_PREFIX + jwt);



    }
}
