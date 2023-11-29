package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IFoyerService {

    Foyer addFoyer(Foyer foyer);
    Foyer editFoyer(Foyer foyer);
    List<Foyer> addFoyers(List<Foyer> foyers);
    List<Foyer> getAll();
    Foyer findById(Long id);
    void deleteById(Long id);
    void delete(Foyer foyer);

    Foyer findByNom(String nom);






}
