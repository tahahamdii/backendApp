package tn.esprit.spring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

@Table(name = "Etudiant")
@Entity
@Setter
@Getter
public class Etudiant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private long idEtudiant;

    @Column(name = "nomEtudiant")
    private String nomET;
    @Column(name = "prenomEt")
    private String prenomEt;
    @Column(name = "cin")
    private long cin;
    @Column(name = "ecole")
    private String ecole;
    @Column (name = "dateNaissance")
    private LocalDate dateNaissance;

    @OneToOne(mappedBy = "etudiant")
    @JsonIgnore
    private Reservation reservation;
}
