package tn.clinique.examen_clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.clinique.examen_clinique.entities.Medecin;

public interface MedecinRepo extends JpaRepository<Medecin,Long> {
}
