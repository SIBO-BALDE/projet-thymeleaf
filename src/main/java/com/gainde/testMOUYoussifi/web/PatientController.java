package com.gainde.testMOUYoussifi.web;

import com.gainde.testMOUYoussifi.entities.PatientEntity;
import com.gainde.testMOUYoussifi.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patient(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "2") int size){
//        List<PatientEntity> patient =patientRepository.findAll();
        Page<PatientEntity> pagePatient =patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("ListPatient", pagePatient.getContent());
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patient";
    }


//    injection de dependances  ajouter un constructeur a partir dune variable qui est en dessus jai comment car jai ajouter @AllArgsConstructor
//    public PatientController(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }
}
