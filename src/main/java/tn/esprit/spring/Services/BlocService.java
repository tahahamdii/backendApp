package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repository.BlocRepository;
import tn.esprit.spring.DAO.Repository.ChambreRepository;
import tn.esprit.spring.DAO.Repository.FoyerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class BlocService implements IBlocService{
    @Autowired
    private BlocRepository blocRepository;
    private ChambreRepository chambreRepository;

    private FoyerRepository foyerRepository;



    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b);
    }

  /*
   @Override
    public List<Bloc> addBlocs(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

   */

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);
    }


    @Override
    public Bloc findByNomBloc(String nomBloc) {
        return  blocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public List<Bloc> findByCapacite(long capacite) {
        return blocRepository.findByCapacite(capacite);
    }

    @Override
    public List<Bloc> findByCapaciteAndNomBloc(long capacite, String nomBloc) {
        return blocRepository.findByCapaciteAndNomBloc(capacite, nomBloc);
    }


    @Override
    public List<Bloc> findByNomBlocIgnoreCase(String nomBloc) {
        return blocRepository.findByNomBlocIgnoreCase(nomBloc);
    }


    @Override
    public List<Bloc> findByCapaciteGreaterThan(long capacite) {
        return blocRepository.findByCapaciteGreaterThan(capacite);
    }

    @Override
    public List<Bloc> findByNomBlocContaining(String subString) {
        return blocRepository.findByNomBlocContaining(subString);
    }

    @Override
    public List<Bloc> findByNomBlocOrderByNomBlocAsc(String nomBloc) {
        return blocRepository.findByNomBlocOrderByNomBlocAsc(nomBloc);
    }

    @Override
    public List<Bloc> findByNomBlocOrCapacite(String nomBloc, long capacite) {
        return blocRepository.findByNomBlocOrCapacite(nomBloc, capacite);
    }

    @Override
    public List<Bloc> findBlocByFoyer(Foyer foyer) {
        return blocRepository.findBlocByFoyer(foyer);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {


        Bloc bloc = findByNomBloc(nomBloc);


        Set<Chambre> chambreSet = new HashSet<>();

        for (long num : numChambre) {
            Optional<Chambre> optionalChambre = chambreRepository.findByNumChambre(num);


            if (optionalChambre.isPresent()) {
                Chambre chambre = optionalChambre.get();
                chambre.setBloc(bloc);
                chambreSet.add(chambre);
                chambreRepository.save(chambre);
            }
        }

        bloc.setChambres(chambreSet);
        blocRepository.save(bloc);
        return bloc;
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Foyer foyer = foyerRepository.findByNom(nomFoyer);
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        Set<Bloc> listblocs = foyer.getBlocs();
        listblocs.add(bloc);
        bloc.setFoyer(foyer);
        foyer.setBlocs(listblocs);
        foyerRepository.save(foyer);
        return bloc;
    }


     /*

    @Override
    public Bloc findBlocByFoyerAndUniversite(Foyer foyer, Universite universite) {
        return blocRepository.findBlocByFoyerAndUniversite(foyer,universite);
    }
*/

}
