package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.User;
import tn.esprit.spring.DAO.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    UserRepository userRepository;

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User editUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void delete(User u) {
        userRepository.delete(u);

    }
}
