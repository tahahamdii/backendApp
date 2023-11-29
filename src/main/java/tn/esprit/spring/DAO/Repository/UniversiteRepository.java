package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);


}
