package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Login;
import tn.esprit.spring.DAO.Entities.LoginRole;

import java.util.Optional;


@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {

    Login findByRole(LoginRole loginRole);

    Optional<Login> findFirstByEmail(String email);
}
