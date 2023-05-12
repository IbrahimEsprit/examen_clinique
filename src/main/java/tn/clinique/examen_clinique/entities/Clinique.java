package tn.clinique.examen_clinique.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClinique;
    private String nomClinique;
    private String adresse;
    private int telephone;

    @ManyToMany
    private List<Medecin> medecins;
}
