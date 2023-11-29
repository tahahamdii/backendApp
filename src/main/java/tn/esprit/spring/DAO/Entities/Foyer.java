package tn.esprit.spring.DAO.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Table(name="Foyer")
@Entity
@Setter
@Getter
public class Foyer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer")
    private long idFoyer;

    @Column(name = "nomFoyer")
    private String nom;

    @Column(name = "capaciteFoyer")
    private long capacite;

    @OneToOne
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;

}
