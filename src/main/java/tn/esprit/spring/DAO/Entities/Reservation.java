package tn.esprit.spring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

@Table(name = "Reservation")
@Entity
@Setter
@Getter
public class Reservation{
@Id
@Column(name = "idReservation")
private String idReservation;


@Column(name = "anneeUniversitaire")
    private LocalDate anneeUniversitaire;

@Column(name = "estValide")
    private Boolean estValide;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @ManyToOne
    @JsonIgnore
    private Chambre chambre;




}
