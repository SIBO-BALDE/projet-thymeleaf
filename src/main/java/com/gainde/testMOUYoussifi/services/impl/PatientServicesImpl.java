package com.gainde.testMOUYoussifi.services.impl;

import com.gainde.testMOUYoussifi.dto.PatientDto;
import com.gainde.testMOUYoussifi.entities.PatientEntity;
import com.gainde.testMOUYoussifi.exceptons.RequestException;
import com.gainde.testMOUYoussifi.mappers.PatientsMappers;
import com.gainde.testMOUYoussifi.repositories.PatientRepository;
import com.gainde.testMOUYoussifi.services.PatientServices;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Locale;

@Service

@Slf4j
public class PatientServicesImpl implements PatientServices {
      private final PatientRepository patientRepository;
      private final PatientsMappers patientsMappers;
      private final  MessageSource messageSource;

    public PatientServicesImpl(PatientRepository patientRepository, PatientsMappers patientsMappers, MessageSource messageSource) {
        this.patientRepository = patientRepository;
        this.patientsMappers = patientsMappers;
        this.messageSource = messageSource;
    }


    @Override
    public PatientDto savePatient(PatientDto patientDto) {
        log.info("save sectorsDto : {}", patientDto);
        if(this.patientRepository.findById(patientDto.getId()).isPresent()){
            throw new RequestException(messageSource.getMessage("patient.exists",
                    new Object[]{patientDto.getId()}, Locale.getDefault()), HttpStatus.CONFLICT);
        }
        if(this.patientRepository.findByNom(patientDto.getNom()).isEmpty()){
            throw new RequestException(messageSource.getMessage("sector.name.exist",
                    new Object[]{patientDto.getNom()}, Locale.getDefault()), HttpStatus.CONFLICT);
        }
        return patientsMappers.toPatientDto(patientRepository.save(patientsMappers.toPatientEntity(patientDto)));
    }





    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        return null;
    }

    @Override
    public PatientDto getNom(String nom, PatientDto patientDto) {
        return null;
    }

    @Override
    public boolean deletePatient(Long id) {
        return false;
    }
}
