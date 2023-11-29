package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.Services.IReservationService;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationRestController {


    IReservationService reservationService;



    @PostMapping("/add")
    Reservation addReservation (@RequestBody Reservation r){
        return reservationService.addReservation(r);
    }
    @PutMapping("/edit/{id}")
    public Reservation editReservation(@PathVariable String id, @RequestBody Reservation updatedReservation) {
        updatedReservation.setIdReservation(id);
        return reservationService.editReservation(updatedReservation);
    }

    @GetMapping("/all")
    public List<Reservation> findAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findById(@PathVariable String id) {
        return reservationService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {

        Optional<Reservation> reservation=reservationService.findById(id);
        if(reservation.isPresent()){
            reservationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/estvalide")
    public ResponseEntity<Set<Reservation>>findByEstValideTrue(){
        return ResponseEntity.ok(reservationService.findByEstValideTrue());
    }
    @GetMapping("/findbyetudiant/{id}")
    public ResponseEntity<Reservation> findReservationByEtudiantId(@PathVariable long id){
        return ResponseEntity.ok(reservationService.findReservationByEtudiantId(id));
    }
    @GetMapping("/anneeuniversitaireetvalide/{annee}")
    public ResponseEntity<Set<Reservation>> findByAnneeUniversitaireAndEstValideTrue(@RequestParam LocalDate annee){
        return ResponseEntity.ok(reservationService.findByAnneeUniversitaireAndEstValideTrue(annee));
    }

}
