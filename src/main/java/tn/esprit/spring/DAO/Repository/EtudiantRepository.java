package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Etudiant;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {




    /* List<Etudiant> findByNomETAndPrenomEt(String nomET, String prenomEt);
    Optional<Etudiant> findByCin(long cin);
    List<Etudiant> findByDateNaissanceAfter(Date date);
    List<Etudiant> findByEcole(String ecole);
    List<Etudiant> findByReservations_IdReservation(String idReservation);
    List<Etudiant> findByReservations_AnneeUniversitaire(Date anneeUniversitaire);
    List<Etudiant> findByEcoleAndDateNaissanceAfter(String ecole, Date date);
    //List<Etudiant> findByReservationsAndAnneeUniversitaireOrderByDateNaissanceAsc(Date anneeUniversitaire);




    Etudiant findByNomETAndPrenomEt(String nom,String prenom);
    Etudiant findByCin(long cin);
    Etudiant findByDateNaissanceAfter(Date date);
    List<Etudiant> findByEcole(String ecole);
    Etudiant findByReservations(Set<Reservation> reservations);
    List<Etudiant> findByEcoleAAndDateNaissanceIsAfter(String ecole,Date date);
    List<Etudiant> findByReservationsOrderByDateNaissance(Set<Reservation> reservationSet);



    5- Recherche des étudiants par réservation (id de réservation)
6- Recherche des étudiants par réservation (année de réservation)
7- Recherche des étudiants par nom d'école et date de naissance après une certaine date
8- Recherche des étudiants par réservation pour une année donnée et triés par date de naissance
    */



}
