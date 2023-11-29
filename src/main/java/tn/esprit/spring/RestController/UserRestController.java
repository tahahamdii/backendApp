package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.DAO.Entities.User;
import tn.esprit.spring.Services.IUserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {

    IUserService iUserService;

    @GetMapping("findAllUsers")
    List<User> findAll(){
        return iUserService.findAll();
    }

    @PostMapping("/addUser")
    User addUser (@RequestBody User u){
        return iUserService.addUser(u);
    }
}

