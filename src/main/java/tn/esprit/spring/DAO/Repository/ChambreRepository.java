package tn.esprit.spring.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.TypeChambre;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    Optional<Chambre> findByNumChambre(long numChambre);
/*
    List<Chambre> findByTypeC(TypeChambre typeC);

    List<Chambre> findByBloc(Bloc bloc);

    List<Chambre> findByBlocAndTypeC(Bloc bloc, TypeChambre typeC);

    List<Chambre> findByNumChambreAndTypeC(long numChambre, TypeChambre typeC);


    //1- Recherche par numéro de chambre
    Optional<Chambre> findByNumChambre(long numChambre);


    //2- Recherche par type de chambre
    List<Chambre> findByTypeC(TypeChambre typeC);


    //3- Recherche des chambres par bloc
    List<Chambre> findByBloc(Bloc bloc);


    //4- Recherche des chambres par bloc et type de chambre
    List<Chambre> findByBlocAndTypeC(Bloc bloc, TypeChambre typeC);


    //5- Recherche des chambres par numéro de chambre et type de chambre
    List<Chambre> findByNumChambreAndTypeC(long numChambre, TypeChambre typeC);

    // 6- Récupérer les chambres en filtrant par le nom de l'université associée au foyer, l'année de réservation et le nom de l'étudiant????
    //List<Chambre> findBy
*/
}
