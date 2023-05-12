package tn.clinique.examen_clinique.services;

import tn.clinique.examen_clinique.entities.Clinique;
import tn.clinique.examen_clinique.entities.Medecin;
import tn.clinique.examen_clinique.entities.RendezVous;
import tn.clinique.examen_clinique.entities.Specialite;

import java.util.List;

public interface Services {
    public Clinique addClinique (Clinique clinique);
    public Medecin addMedecinAndAssignToClinique (Medecin medecin, Long cliniqueId);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
    public int getNbrRendezVousMedecin(Long idMedecin);
    public void retrieveRendezVous();
}
