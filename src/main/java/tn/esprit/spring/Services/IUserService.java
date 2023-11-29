package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User addUser(User u);
    User editUser(User u);

    List<User> addUsers(List<User> users);
    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);

    void delete(User u);
}
