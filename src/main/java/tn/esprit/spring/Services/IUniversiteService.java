package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {

    Universite addUniversite(Universite u);
    Universite editUniversite(Universite u);


    List<Universite> findAll();

    Universite findById(long idUniversite);

    void deleteById(Long id);

    void delete(Universite u);

    Universite findUniversiteByNomUniversite(String nomUniversite);

    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
