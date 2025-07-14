package com.gainde.testMOUYoussifi.web;

import com.gainde.testMOUYoussifi.entities.PatientEntity;
import com.gainde.testMOUYoussifi.repositories.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patient(Model model,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String keyword
    ){
//        List<PatientEntity> patient =patientRepository.findAll();
        Page<PatientEntity> pagePatient =patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListPatient", pagePatient.getContent());
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patient";
    }
    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/formPatients")
    public String formPatients(Model model){
        model.addAttribute("patient", new PatientEntity());
        return "formPatients";
    }

    @PostMapping("/save")
    public String save(Model model,
                       @Valid @ModelAttribute("patient") PatientEntity patient,
                       BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") String keyword,
                       @RequestParam(defaultValue = "")int page) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patient", patient);
//            model.addAttribute("page", page);
//            model.addAttribute("keyword", keyword);
            return "formPatients";
        }

        patientRepository.save(patient);
        model.addAttribute("patient", new PatientEntity());
        model.addAttribute("message", "Patient enregistré avec succès !");
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id, String keyword, int page){
        PatientEntity patient =patientRepository.findById(id).orElse(null);
        if (patient==null)throw  new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatient";
    }



}
