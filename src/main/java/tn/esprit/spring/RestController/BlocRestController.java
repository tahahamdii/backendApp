package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Bloc;

import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.Services.IBlocService;

import java.security.PublicKey;
import java.util.List;



@RestController
@AllArgsConstructor
@RequestMapping("/api/blocs")
public class BlocRestController {


    @Autowired
    private IBlocService blocService;

    @GetMapping("/allblocs")
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.findAll();
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.findById(id);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addBloc")
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc bloc) {
        Bloc createdBloc = blocService.addBloc(bloc);
        return ResponseEntity.ok(createdBloc);
    }

    @PutMapping("/editbloc/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        Bloc existingBloc = blocService.findById(id);
        if (existingBloc != null) {
            bloc.setIdBloc(id);
            Bloc updatedBloc = blocService.editBloc(bloc);
            return ResponseEntity.ok(updatedBloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteBloc/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        Bloc existingBloc = blocService.findById(id);
        if (existingBloc != null) {
            blocService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/byNomBloc")
    public ResponseEntity<Bloc> findBlocsByNomBloc(@RequestParam String nomBloc) {
        Bloc blocs = blocService.findByNomBloc(nomBloc);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byCapaciteBloc")
    public ResponseEntity<List<Bloc>> findBlocsByCapaciteBloc(@RequestParam long capacite) {
        List<Bloc> blocs = blocService.findByCapacite(capacite);
        return ResponseEntity.ok(blocs);
    }


    @GetMapping("/byNomBlocAndCapaciteBloc")
    public ResponseEntity<List<Bloc>> findBlocsByNomBlocAndCapaciteBloc(@RequestParam String nomBloc, @RequestParam long capacite) {
        List<Bloc> blocs = blocService.findByCapaciteAndNomBloc(capacite, nomBloc);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byNomBlocIgnoreCase")
    public ResponseEntity<List<Bloc>> findBlocsByNomBlocIgnoreCase(@RequestParam String nomBloc) {
        List<Bloc> blocs = blocService.findByNomBlocIgnoreCase(nomBloc);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byCapaciteGreaterThan")
    public ResponseEntity<List<Bloc>> findBlocsByCapaciteGreaterThan(@RequestParam long capacite) {
        List<Bloc> blocs = blocService.findByCapaciteGreaterThan(capacite);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byNomBlocContaining")
    public ResponseEntity<List<Bloc>> findBlocsByNomBlocContaining(@RequestParam String subString) {
        List<Bloc> blocs = blocService.findByNomBlocContaining(subString);
        return ResponseEntity.ok(blocs);
    }


    @GetMapping("/orderByNomBlocAsc")
    public ResponseEntity<List<Bloc>> findBlocsOrderByNomBlocAsc(String nom) {
        List<Bloc> blocs = blocService.findByNomBlocOrderByNomBlocAsc(nom);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byNomBlocOrCapaciteBloc")
    public ResponseEntity<List<Bloc>> findBlocsByNomBlocOrCapaciteBloc(@RequestParam String nomBloc, @RequestParam long capacite) {
        List<Bloc> blocs = blocService.findByNomBlocOrCapacite(nomBloc, capacite);
        return ResponseEntity.ok(blocs);
    }

    @GetMapping("/byFoyer")
    public List<Bloc> findBlocByFoyer(@RequestBody Foyer foyer) {
        return blocService.findBlocByFoyer(foyer);
    }

    @PutMapping("/ChambresABloc")
    public ResponseEntity<Bloc> affecterChmabreABloc(@RequestParam List<Long> numChmabres,@RequestParam String nomBloc) {
        return ResponseEntity.ok(blocService.affecterChambresABloc(numChmabres,nomBloc));

    }
    @PutMapping("/affecterBlocAFoyer")
    public ResponseEntity<Bloc> affecterBlocAfoyer(@RequestParam String nomBloc,@RequestParam String nomFoyer){
        return ResponseEntity.ok(blocService.affecterBlocAFoyer(nomBloc,nomFoyer));
    }

    //affecterChambresABloc(List<Long> numChambre, String nomBloc)
/*
    @GetMapping("/byFoyerAndUniversite")
    public ResponseEntity<Bloc> findBlocByFoyerAndUniversite(@RequestParam Foyer foyer, @RequestParam Universite universite) {
        Bloc bloc = blocService.findBlocByFoyerAndUniversite(foyer, universite);
        return ResponseEntity.ok(bloc);
    }

 */
}
