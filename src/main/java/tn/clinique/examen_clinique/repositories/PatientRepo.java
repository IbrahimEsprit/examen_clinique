package tn.clinique.examen_clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.clinique.examen_clinique.entities.Clinique;
import tn.clinique.examen_clinique.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
