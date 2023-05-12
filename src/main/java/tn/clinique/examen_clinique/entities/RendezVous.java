package tn.clinique.examen_clinique.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    private Date dateRDV;
    private String remarque;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patient;
}
