package tn.clinique.examen_clinique.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.clinique.examen_clinique.entities.*;
import tn.clinique.examen_clinique.repositories.CliniqueRepo;
import tn.clinique.examen_clinique.repositories.MedecinRepo;
import tn.clinique.examen_clinique.repositories.PatientRepo;
import tn.clinique.examen_clinique.repositories.RendezVousRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesImp implements Services{

    private final CliniqueRepo cliniqueRepo;
    private final MedecinRepo medecinRepo;
    private final PatientRepo patientRepo;
    private final RendezVousRepo rendezVousRepo;
    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }


    @Transactional
    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique C = cliniqueRepo.findById(cliniqueId).orElse(null);

        Assert.notNull(C,"Clinique not found!");

        medecinRepo.saveAndFlush(medecin);
        C.getMedecins().add(medecin);
        return medecin;
    }

    @Transactional
    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin M = medecinRepo.findById(idMedecin).orElse(null);
        Patient P = patientRepo.findById(idPatient).orElse(null);

        Assert.notNull(M,"Cl");
        Assert.notNull(P,"Clound");

        rendezVousRepo.saveAndFlush(rdv);
        rdv.setMedecin(M);
        rdv.setPatient(P);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepo.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique,specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepo.countRendezVousByMedecinIdMedecin(idMedecin);
    }

    @Scheduled(cron = "*/30* * * * *")
    @Override
    public void retrieveRendezVous() {
        List<RendezVous> listr = rendezVousRepo.findByDateRDVAfter(new Date())
        if (listr.isEmpty()) {
            System.out.println("La liste des RendezVous est vide .11111111111477824655565");
        } else {
            for (RendezVous r : listr) {
                System.out.println("La liste des RendezVous:" + r.getDateRDV() + ": Medecin :" + r.getMedecin().getNomMedecin() + "Patient" + r.getPatient().getNomPatient());
            }
        }
    }
}
