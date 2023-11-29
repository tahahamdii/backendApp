package tn.esprit.spring.Services.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Login;
import tn.esprit.spring.DAO.Repository.LoginRepository;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Login> userOptional = loginRepository.findFirstByEmail(email);
        if(userOptional.isEmpty()) throw new UsernameNotFoundException("Username not found",null);
        return new org.springframework.security.core.userdetails.User(userOptional.get().getEmail(),userOptional.get().getPassword(),new ArrayList<>());

    }
}
