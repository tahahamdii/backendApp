package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.DAO.Repository.EtudiantRepository;
import tn.esprit.spring.DAO.Repository.ReservationRepository;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Service
public class ReservationService implements IReservationService{

    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation editReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation r) {
        reservationRepository.delete(r);
    }

    @Override
    public Set<Reservation> findByEstValideTrue() {
        return reservationRepository.findByEstValideTrue();
    }

    @Override
    public Reservation findReservationByEtudiantId(long idEtudiant) {

        Optional<Etudiant> etudiant = etudiantRepository.findById(idEtudiant);

            return reservationRepository.findReservationByEtudiant(etudiant.get());

    }

    @Override
    public Set<Reservation> findByAnneeUniversitaireAndEstValideTrue(LocalDate annee) {
        return reservationRepository.findReservationByAnneeUniversitaireAndAndEstValideTrue(annee);
    }





/*
    @Override
    public List<Reservation> findValidatedReservations() {
        return reservationRepository.findByEstValide(true);
    }

    @Override
    public List<Reservation> findReservationsByEtudiantId(Long etudiantId) {
        return reservationRepository.findByEtudiants_IdEtudiant(etudiantId);
    }

    @Override
    public List<Reservation> findReservationsByAnneeAndValidity(Date anneeUniversitaire, Boolean estValide) {
        return reservationRepository.findByAnneeUniversitaireAndEstValide(anneeUniversitaire, estValide);
    }

     */

}
