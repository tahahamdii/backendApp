package tn.esprit.spring.Services.admin;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Login;
import tn.esprit.spring.DAO.Entities.LoginRole;
import tn.esprit.spring.DAO.Repository.LoginRepository;

@Service
public class AdminServiceImpl {

    private final LoginRepository loginRepository ;

    public AdminServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

@PostConstruct
    public void createAdminAccount(){
    Login adminAccount = loginRepository.findByRole(LoginRole.ADMIN);

    if (adminAccount == null) {
            Login admin = new Login();
            admin.setEmail("Admin@test.com");
            admin.setName("admin");
            admin.setRole(LoginRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            loginRepository.save(admin);
        }

    }
}
