package com.gainde.testMOUYoussifi.repositories;

import com.gainde.testMOUYoussifi.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/* #cette interface herite de lentites de jpa quon appele jpaRepository  et lentitier que je gere est patient*/
public interface PatientRepository  extends JpaRepository<PatientEntity, Long> {
    List<PatientEntity> findByNom(String nom);
    List<PatientEntity> findByPrenom(String prenom);
    // Rechercher par email
    PatientEntity findByEmail(String email);
    // Rechercher les patients dont le nom contient un mot-clé
    List<PatientEntity> findByNomContaining(String keyword);

    // Rechercher par nom ET prénom
    List<PatientEntity> findByNomAndPrenom(String nom, String prenom);;





}
