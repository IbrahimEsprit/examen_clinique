package tn.clinique.examen_clinique.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.clinique.examen_clinique.entities.Clinique;
import tn.clinique.examen_clinique.entities.Medecin;
import tn.clinique.examen_clinique.entities.RendezVous;
import tn.clinique.examen_clinique.entities.Specialite;
import tn.clinique.examen_clinique.services.Services;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controllers {
    private final Services iServices;

    @PostMapping("/addclinique")
    public Clinique addClinique (@RequestBody Clinique clinique) {
        return iServices.addClinique(clinique);
    }

    @PostMapping("/addmedecin/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique (@RequestBody Medecin medecin,@PathVariable Long cliniqueId) {
        return iServices.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }

    @PostMapping("/addrdv/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv,@PathVariable Long idMedecin,@PathVariable Long idPatient) {
        iServices.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }
    @GetMapping("/rdv/{idClinique}/{specialite}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite) {
        return iServices.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @GetMapping("/rdv/{idMedecin}")
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return iServices.getNbrRendezVousMedecin(idMedecin);
    }



}
