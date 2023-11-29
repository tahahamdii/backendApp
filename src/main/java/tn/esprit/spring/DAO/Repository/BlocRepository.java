package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {



    //1- Recherche par nomBloc
    Bloc findByNomBloc(String nomBloc);
    //2- Recherche par capaciteBloc
    List<Bloc> findByCapacite(long capacite);
    //3- Recherche par nomBloc et capaciteBloc
    List<Bloc> findByCapaciteAndNomBloc(long capacite, String nomBloc);
    //4- Recherche par nomBloc en ignorant la casse
    List<Bloc> findByNomBlocIgnoreCase(String nomBloc);
    //5- Recherche par capaciteBloc supérieure à une valeur donnée
    List<Bloc> findByCapaciteGreaterThan(long capacite);
    //6- Recherche par nomBloc contenant une sous-chaîne
    List<Bloc> findByNomBlocContaining(String subString);
    //7- Tri par nomBloc par ordre alphabétique
    List<Bloc> findByNomBlocOrderByNomBlocAsc(String nomBloc);
    //8- Recherche par nomBloc ou capaciteBloc
    List<Bloc> findByNomBlocOrCapacite(String nomBloc, long capacite);


    //9- Recherche du bloc d'un foyer spécifique
    List<Bloc> findBlocByFoyer(Foyer foyer);
 /*

    //10- Recherche du bloc pour un foyer d'une université donnée

    //public Bloc findBlocByFoyerAndUniversity(String nomUniversite, Foyer foyer) ;

*/

}
