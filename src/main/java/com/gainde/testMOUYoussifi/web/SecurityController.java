package com.gainde.testMOUYoussifi.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/403")
    public String accessDenied() {
//        iL doit me renvoyer une page 403.html
            return "403";
        }
    }



