package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant editEtudiant(Etudiant etudiant);
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    List<Etudiant> findAllEtudiants();
    Etudiant findById(Long id);
    void deleteById(Long id);
    void delete(Etudiant etudiant);

    /*

    List<Etudiant> findEtudiantsByNomAndPrenom(String nomET, String prenomEt);
    Optional<Etudiant> findEtudiantByCin(long cin);
    List<Etudiant> findEtudiantsByDateNaissanceAfter(Date date);
    List<Etudiant> findEtudiantsByEcole(String ecole);
    List<Etudiant> findEtudiantsByReservationId(String idReservation);
    List<Etudiant> findEtudiantsByReservationYear(Date anneeUniversitaire);
    List<Etudiant> findEtudiantsByEcoleAndDateNaissanceAfter(String ecole, Date date);
    List<Etudiant> findEtudiantsByReservationYearAndOrderByDateNaissanceAsc(Date anneeUniversitaire);
    */


}
