package com.gainde.testMOUYoussifi.services;

import com.gainde.testMOUYoussifi.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientServices {
    PatientDto save(PatientDto patientDto);
    PatientDto update(PatientDto patientDto);
    PatientDto get(Long id);
    PatientDto getByNom(String firstName);
    boolean delete(Long id);
    List<PatientDto> getAll();

}
