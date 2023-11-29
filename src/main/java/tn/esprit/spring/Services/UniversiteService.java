package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.DAO.Repository.FoyerRepository;
import tn.esprit.spring.DAO.Repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite editUniversite(Universite u) {
        return universiteRepository.save(u);
    }



    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }


    @Override
    public void deleteById(Long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public void delete(Universite u) {
        universiteRepository.delete(u);

    }

    @Override
    public Universite findUniversiteByNomUniversite(String nomUniversite) {
        return universiteRepository.findUniversiteByNomUniversite(nomUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        Universite universite=universiteRepository.findUniversiteByNomUniversite(nomUniversite);
        foyerRepository.save(foyer);
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);

        return universite;


    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite U = universiteRepository.findById(idUniversite).get();
        U.setFoyer(null);
        universiteRepository.save(U);
        return U;
    }


}
