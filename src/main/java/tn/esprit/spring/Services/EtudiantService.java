package tn.esprit.spring.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Etudiant;

import tn.esprit.spring.DAO.Repository.EtudiantRepository;


import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class EtudiantService implements IEtudiantService{
   @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant editEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public List<Etudiant> findAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void delete(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }
/*
    @Override
    public List<Etudiant> findEtudiantsByNomAndPrenom(String nomET, String prenomEt) {
        return etudiantRepository.findByNomETAndPrenomEt(nomET, prenomEt);
    }

    @Override
    public Optional<Etudiant> findEtudiantByCin(long cin) {
        return etudiantRepository.findByCin(cin);
    }

    @Override
    public List<Etudiant> findEtudiantsByDateNaissanceAfter(Date date) {
        return etudiantRepository.findByDateNaissanceAfter(date);
    }

    @Override
    public List<Etudiant> findEtudiantsByEcole(String ecole) {
        return etudiantRepository.findByEcole(ecole);
    }

    @Override
    public List<Etudiant> findEtudiantsByReservationId(String idReservation) {
        return etudiantRepository.findByReservations_IdReservation(idReservation);
    }

    @Override
    public List<Etudiant> findEtudiantsByReservationYear(Date anneeUniversitaire) {
        return etudiantRepository.findByReservations_AnneeUniversitaire(anneeUniversitaire);
    }

    @Override
    public List<Etudiant> findEtudiantsByEcoleAndDateNaissanceAfter(String ecole, Date date) {
        return etudiantRepository.findByEcoleAndDateNaissanceAfter(ecole, date);
    }

    @Override
    public List<Etudiant> findEtudiantsByReservationYearAndOrderByDateNaissanceAsc(Date anneeUniversitaire) {
        List<Etudiant> etudiants = etudiantRepository.findByReservations_AnneeUniversitaire(anneeUniversitaire);
        etudiants.sort(Comparator.comparing(Etudiant::getDateNaissance));
        return etudiants;
    }
    */

}
