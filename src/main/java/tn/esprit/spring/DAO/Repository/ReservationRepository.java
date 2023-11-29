package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {

    Set<Reservation> findByEstValideTrue();
    Reservation findReservationByEtudiant(Etudiant etudiant);

    Set<Reservation> findReservationByAnneeUniversitaireAndAndEstValideTrue(LocalDate anne);



    /*

1- Recherche des réservations validées
2- Recherche des réservations par l'id de l'étudiant
3- Recherche des réservations par année et validité

*/
}
