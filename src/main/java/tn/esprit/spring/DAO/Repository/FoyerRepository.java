package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;

import java.util.List;
import java.util.Set;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNom(String nom);
    List<Foyer> findAll();
   /* List<Foyer> findByBlocs(Set<Bloc> blocs);
    List<Foyer> findByBlocsAndCapaciteFoyer(Bloc bloc, long capacite);

*/

}

