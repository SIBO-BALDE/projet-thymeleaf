package com.gainde.testMOUYoussifi.web;

import com.gainde.testMOUYoussifi.entities.PatientEntity;
import com.gainde.testMOUYoussifi.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patient(Model model){
        List<PatientEntity> patient =patientRepository.findAll();
        model.addAttribute("ListPatient", patient);
        return "patient";
    }


//    injection de dependances  ajouter un constructeur a partir dune variable qui est en dessus jai comment car jai ajouter @AllArgsConstructor
//    public PatientController(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }
}
