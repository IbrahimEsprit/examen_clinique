package tn.clinique.examen_clinique.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nompatient;
    private int telephone;
    private Date dateNaissance;
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> RendezVouss;
}
