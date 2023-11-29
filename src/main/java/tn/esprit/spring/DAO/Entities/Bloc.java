package tn.esprit.spring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Table(name = "Bloc")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor

public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloc")
    private long idBloc;

    @Column(name = "nomBloc")
    private String nomBloc;

    @Column(name = "capaciteBloc")
    private long capacite;

    @ManyToOne
    @JsonIgnore
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc",cascade = ALL)
    private Set<Chambre> chambres;


    public Bloc() {

    }
}
