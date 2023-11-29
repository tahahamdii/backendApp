package tn.esprit.spring.DAO.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.time.LocalDate;

@Table(name="utilisateur")
@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id ;
    @Column(name = "firstName")
    private String nom;

    @Column(name = "lastName")
    private String prenom;
    private LocalDate dateNaissance;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Temporal(TemporalType.DATE) //YYYY-MM-JJ hh:mm:ss
    private Date dateInscription; //java.util

    @Transient
    private int age; //pour ne pas mapper l'attribut dans la BD
}
