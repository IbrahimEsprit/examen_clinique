package tn.clinique.examen_clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.clinique.examen_clinique.entities.Clinique;
import tn.clinique.examen_clinique.entities.RendezVous;
import tn.clinique.examen_clinique.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous,Integer> {

    List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long idClinique, Specialite specialite);

    int countRendezVousByMedecinIdMedecin(Long idMedecin);

    List<RendezVous> findByDateRDVAfter(Date date);
}
