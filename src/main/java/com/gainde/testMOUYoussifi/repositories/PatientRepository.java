package com.gainde.testMOUYoussifi.repositories;

import com.gainde.testMOUYoussifi.entities.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository  extends JpaRepository<PatientEntity, Long> {
    Page<PatientEntity> findByNomContains(String kw, Pageable pageable);

}
