package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.Services.IUniversiteService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/universites")
public class UniversiteRestController {




    @Autowired
    private IUniversiteService universiteService;

    @GetMapping("/all")
    public ResponseEntity<List<Universite>> getAllUniversites() {
        List<Universite> universites = universiteService.findAll();
        return ResponseEntity.ok(universites);
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        Universite universite = universiteService.findById(id);
        if (universite != null) {
            return ResponseEntity.ok(universite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Universite> createUniversite(@RequestBody Universite universite) {
        Universite createdUniversite = universiteService.addUniversite(universite);
        return ResponseEntity.ok(createdUniversite);
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        Universite existingUniversite = universiteService.findById(id);
        if (!(existingUniversite == null)) {
            universite.setIdUniversite(id);
            Universite updatedUniversite = universiteService.editUniversite(universite);
            return ResponseEntity.ok(updatedUniversite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteByid/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public ResponseEntity<Universite> affecterFoyerAUniversite(@PathVariable long idFoyer,@PathVariable String nomUniversite){
      return ResponseEntity.ok(universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite));

    }

    @GetMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite){
        return universiteService.desaffecterFoyerAUniversite(idUniversite);

    }



}
