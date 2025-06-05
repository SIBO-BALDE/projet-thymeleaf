package com.gainde.testMOUYoussifi.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class PatientDto implements Serializable {

    private long id;
    @NotBlank(message = "prenom is required")
    private String prenom;
    @NotBlank(message = "nom is required")
    private String nom;
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "dateNaissance is required")
    private Integer dateNaissance;
    private boolean malade;


}
