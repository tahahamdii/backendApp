package tn.esprit.spring.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repository.FoyerRepository;

import java.util.List;
import java.util.Set;


@Service
public class FoyerService implements IFoyerService{

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer editFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public List<Foyer> getAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(Long id) {
        return foyerRepository.findById(id).get();
    }


    @Override
    public void deleteById(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
     public Foyer findByNom(String nom) {
        return  foyerRepository.findByNom(nom);
    }

   /* @Override
    public List<Foyer> findFoyersByBlocs(Set<Bloc> bloc) {
        return foyerRepository.findByBlocs(bloc);
    }



    @Override
    public List<Foyer> findFoyersByBlocsAndCapacite(Bloc bloc, long capacite) {
        return foyerRepository.findByBlocsAndCapaciteFoyer(bloc, capacite);
    }
*/

}
