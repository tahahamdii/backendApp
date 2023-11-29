package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;

import java.util.List;

public interface IBlocService {

    Bloc addBloc(Bloc bloc);
    Bloc editBloc(Bloc b);


    List<Bloc> findAll();

    Bloc findById(Long id);

    void deleteById(Long id);

    void delete(Bloc b);



    //1- Recherche par nomBloc
    Bloc findByNomBloc(String nomBloc);

    //2- Recherche par capaciteBloc
    List<Bloc> findByCapacite(long capacite);

    //3- Recherche par nomBloc et capaciteBloc
    List<Bloc> findByCapaciteAndNomBloc(long capacite ,String nomBloc);

    //4- Recherche par nomBloc en ignorant la casse

    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);

    //5- Recherche par capaciteBloc supérieure à une valeur donnée
    List<Bloc> findByCapaciteGreaterThan(long capacite);

    //6- Recherche par nomBloc contenant une sous-chaîne
    List<Bloc> findByNomBlocContaining(String subString);

    //7- Tri par nomBloc par ordre alphabétique
    List<Bloc> findByNomBlocOrderByNomBlocAsc(String nomBloc);

    //8- Recherche par nomBloc ou capaciteBloc
    List<Bloc> findByNomBlocOrCapacite(String nomBloc , long capacite);

    //9- Recherche du bloc d'un foyer spécifique
    List<Bloc> findBlocByFoyer(Foyer foyer);

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ;

    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;
/*
   // Bloc findBlocByFoyerAndUniversite(Foyer foyer, Universite universite);

 */
}
