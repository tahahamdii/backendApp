package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.TypeChambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {

    Chambre addChambre(Chambre c);
    Chambre editChambre(Chambre c);

    List<Chambre> addChambres(List<Chambre> chambres);
    List<Chambre> findAllChambres();

    Optional<Chambre> findById(Long id);

    void deleteById(Long id);

    void delete(Chambre b);




    Optional<Chambre> findByNumChambre(long numChambre);

 /*

    List<Chambre> findByTypeC(TypeChambre typeC);



    List<Chambre> findByBloc(Bloc bloc);



    List<Chambre> findByBlocAndTypeC(Bloc bloc, TypeChambre typeC);



    List<Chambre> findByNumChambreAndTypeC(long numChambre, TypeChambre typeC);

 */



}
