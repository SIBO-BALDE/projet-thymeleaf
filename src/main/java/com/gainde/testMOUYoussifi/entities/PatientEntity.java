package com.gainde.testMOUYoussifi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private  String prenom;
    @Column(length = 50)
    private  String nom;
    private  String email;
    /* je utilise ce temporal pour lui dire que je veux recuperer que la date pas besoin de recuperer les minutes*/
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;

}
