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
                          @RequestParam(name = "size", defaultValue = "2") int size,
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
//    @PostMapping(path = "/save")
//    public String save(Model model, PatientEntity patient){
//        patientRepository.save(patient);
//        return "formPatients";
//    }
//@PostMapping(path = "/save")
//public String save(Model model, @Valid PatientEntity patient, BindingResult bindingResult){
//        if (bindingResult.hasErrors()) return "redirect:/index";
//    patientRepository.save(patient);
//    return "redirect:/index";
//}

    @PostMapping(path = "/save")
    public String save(Model model, @Valid PatientEntity patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("patient", patient); // 🟢 Nécessaire pour afficher à nouveau les champs remplis
            return "formPatients";
        }

        patientRepository.save(patient);
        model.addAttribute("patient", new PatientEntity()); // 🆕 Formulaire vide après succès
        model.addAttribute("message", "Patient enregistré avec succès !");
        return "formPatients";
    }



}
