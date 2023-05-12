package tn.clinique.examen_clinique.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.clinique.examen_clinique.entities.Clinique;

public interface CliniqueRepo extends JpaRepository<Clinique,Long> {
}
