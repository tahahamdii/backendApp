package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.Services.IEtudiantService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantRestController {


    @Autowired
    private IEtudiantService etudiantService;

    @GetMapping("all")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.findAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> etudiant = Optional.ofNullable(etudiantService.findById(id));
        return etudiant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.addEtudiant(etudiant);
        return ResponseEntity.ok(createdEtudiant);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantService.findById(id);
        if (!(existingEtudiant == null)) {
            etudiant.setIdEtudiant(id);
            Etudiant updatedEtudiant = etudiantService.editEtudiant(etudiant);
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.findById(id);

        if (null != etudiant) {
            etudiantService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*

    @GetMapping("/byNomAndPrenom")
    public ResponseEntity<List<Etudiant>> getEtudiantsByNomAndPrenom(
            @RequestParam String nomET,
            @RequestParam String prenomEt
    ) {
        List<Etudiant> etudiants = etudiantService.findEtudiantsByNomAndPrenom(nomET, prenomEt);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byCIN")
    public ResponseEntity<Etudiant> getEtudiantByCIN(@RequestParam long cin) {
        Optional<Etudiant> etudiant = etudiantService.findEtudiantByCin(cin);
        if (etudiant.isPresent()) {
            return ResponseEntity.ok(etudiant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byDateNaissanceAfter")
    public ResponseEntity<List<Etudiant>> getEtudiantsByDateNaissanceAfter(@RequestParam Date dateNaissance) {

        List<Etudiant> etudiants;
        etudiants = etudiantService.findEtudiantsByDateNaissanceAfter(dateNaissance);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byEcole")
    public ResponseEntity<List<Etudiant>> getEtudiantsByEcole(@RequestParam String ecole) {
        List<Etudiant> etudiants = etudiantService.findEtudiantsByEcole(ecole);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byReservationId")
    public ResponseEntity<List<Etudiant>> getEtudiantsByReservationId(@RequestParam String idReservation) {
        List<Etudiant> etudiants = etudiantService.findEtudiantsByReservationId(idReservation);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byReservationYear")
    public ResponseEntity<List<Etudiant>> getEtudiantsByReservationYear(@RequestParam Date anneeUniversitaire) {
        // Convert the year parameter to a proper date format
        // You may need to adjust the date format parsing based on your needs
        // Example: SimpleDateFormat or LocalDate.parse
        List<Etudiant> etudiants = etudiantService.findEtudiantsByReservationYear(anneeUniversitaire);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byEcoleAndDateNaissanceAfter")
    public ResponseEntity<List<Etudiant>> getEtudiantsByEcoleAndDateNaissanceAfter(
            @RequestParam String ecole,
            @RequestParam Date dateNaissance
    ) {

        List<Etudiant> etudiants = etudiantService.findEtudiantsByEcoleAndDateNaissanceAfter(ecole, dateNaissance);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/byReservationYearAndOrderByDateNaissanceAsc")
    public ResponseEntity<List<Etudiant>> getEtudiantsByReservationYearAndOrderByDateNaissanceAsc(
            @RequestParam Date anneeUniversitaire
    ) {

        List<Etudiant> etudiants = etudiantService.findEtudiantsByReservationYearAndOrderByDateNaissanceAsc(anneeUniversitaire);
        return ResponseEntity.ok(etudiants);
    }

     */
}