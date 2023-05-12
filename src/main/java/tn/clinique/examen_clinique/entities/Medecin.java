package tn.clinique.examen_clinique.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private int telephone;
    private int prixConsultation;
    @JsonIgnore
    @ManyToMany(mappedBy = "medecins")
    private List<Clinique> cliniques;
    @OneToMany (mappedBy = "medecin")
    private List<RendezVous> rendezVouss;
}
