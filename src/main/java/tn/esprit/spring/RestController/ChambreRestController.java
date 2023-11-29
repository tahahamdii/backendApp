package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.TypeChambre;
import tn.esprit.spring.Services.IChambreService;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/chambres")
public class ChambreRestController {


    @Autowired
    private IChambreService chambreService;

    @GetMapping("/all")
    public ResponseEntity<List<Chambre>> getAllChambres() {
        List<Chambre> chambres = chambreService.findAllChambres();
        return ResponseEntity.ok(chambres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreService.findById(id);
        return chambre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Chambre> addChambre(@RequestBody Chambre chambre) {
        Chambre createdChambre = chambreService.addChambre(chambre);
        return ResponseEntity.ok(createdChambre);
    }

    @PutMapping("/editbyid/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        Optional<Chambre> existingChambre = chambreService.findById(id);
        if (existingChambre.isPresent()) {
            chambre.setIdChambre(id);
            Chambre updatedChambre = chambreService.editChambre(chambre);
            return ResponseEntity.ok(updatedChambre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        Optional<Chambre> ch=chambreService.findById(id);
        if (ch.isPresent()) {
            chambreService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
    /*

    @GetMapping("/byNumChambre")
    public ResponseEntity<Chambre> getChambreByNumChambre(@RequestParam long numChambre) {
        Optional<Chambre> chambre = chambreService.findByNumChambre(numChambre);
        return chambre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byTypeC")
    public ResponseEntity<List<Chambre>> getChambresByTypeC(@RequestParam TypeChambre typeC) {
        List<Chambre> chambres = chambreService.findByTypeC(typeC);
        return ResponseEntity.ok(chambres);
    }
    @GetMapping("/byBloc")
    public ResponseEntity<List<Chambre>> getChambresByBloc(@RequestBody Bloc bloc) {
        List<Chambre> chambres = chambreService.findByBloc(bloc);
        return ResponseEntity.ok(chambres);
    }


    @GetMapping("/byBlocAndTypeC")
    public ResponseEntity<List<Chambre>> getChambresByBlocAndTypeC(@RequestBody Bloc bloc, @RequestParam TypeChambre typeC) {
        List<Chambre> chambres = chambreService.findByBlocAndTypeC(bloc, typeC);
        return ResponseEntity.ok(chambres);
    }


    @GetMapping("/byNumChambreAndTypeC")
    public ResponseEntity<List<Chambre>> getChambreByNumChambreAndTypeC(@RequestParam long numChambre, @RequestParam TypeChambre typeC) {
        List<Chambre> chambres = chambreService.findByNumChambreAndTypeC(numChambre, typeC);

        if (chambres.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(chambres);
        }
    }

 */
}

