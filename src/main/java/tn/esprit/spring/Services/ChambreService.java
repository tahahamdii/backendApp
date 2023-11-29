package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.TypeChambre;
import tn.esprit.spring.DAO.Repository.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre editChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> addChambres(List<Chambre> chambres) {
        return chambreRepository.saveAll(chambres);
    }

    @Override
    public List<Chambre> findAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Optional<Chambre> findById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public void delete(Chambre b) {
        chambreRepository.delete(b);
    }

    @Override
    public Optional<Chambre> findByNumChambre(long numChambre) {
        return chambreRepository.findByNumChambre(numChambre);
    }
    /*

    @Override
    public List<Chambre> findByTypeC(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public List<Chambre> findByBloc(Bloc bloc) {
        return chambreRepository.findByBloc(bloc);
    }

    @Override
    public List<Chambre> findByBlocAndTypeC(Bloc bloc, TypeChambre typeC) {
        return chambreRepository.findByBlocAndTypeC(bloc, typeC);
    }

    @Override
    public List<Chambre> findByNumChambreAndTypeC(long numChambre, TypeChambre typeC) {
        return chambreRepository.findByNumChambreAndTypeC(numChambre, typeC);
    }

 */
}
