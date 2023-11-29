package tn.esprit.spring.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "chambre")
@Entity
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Chambre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre")
    private long idChambre;

    @Column(name = "numeChambre")
    private long numChambre;
    @Column(name="typeC")
    private TypeChambre typeC;

    @ManyToOne
    @JsonIgnore
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();
    public Chambre() {

    }
}
