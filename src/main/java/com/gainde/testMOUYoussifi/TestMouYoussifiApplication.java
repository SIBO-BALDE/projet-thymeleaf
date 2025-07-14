package com.gainde.testMOUYoussifi;


import com.gainde.testMOUYoussifi.entities.PatientEntity;
import com.gainde.testMOUYoussifi.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
	public class TestMouYoussifiApplication {

		public static void main(String[] args) {
			SpringApplication.run(TestMouYoussifiApplication.class, args);
		}
		@Bean
		CommandLineRunner commandLineRunner(PatientRepository patientRepository){
			return  args -> {
				patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,60));
				patientRepository.save(new PatientEntity(null ,"Hawa", new Date(),false,70));
				patientRepository.save(new PatientEntity(null ,"Bilal", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Zeynab", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Haby", new Date(),false,80));patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,60));
				patientRepository.save(new PatientEntity(null ,"Yacine", new Date(),false,70));
				patientRepository.save(new PatientEntity(null ,"Ousmane", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Dieynaba", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Ibrahim", new Date(),false,80));patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,60));
				patientRepository.save(new PatientEntity(null ,"Alym", new Date(),false,70));
				patientRepository.save(new PatientEntity(null ,"Dior", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Aicha", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Aliou", new Date(),false,80));patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,60));
				patientRepository.save(new PatientEntity(null ,"Zackaria", new Date(),false,70));
				patientRepository.save(new PatientEntity(null ,"Zeynoul", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Abib", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Aziz", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Aicha", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Aliou", new Date(),false,80));patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,60));
				patientRepository.save(new PatientEntity(null ,"Mansour", new Date(),false,70));
				patientRepository.save(new PatientEntity(null ,"Alima", new Date(),false,80));
				patientRepository.save(new PatientEntity(null ,"Khadija", new Date(),false,90));
				patientRepository.save(new PatientEntity(null ,"Malick", new Date(),false,80));

				patientRepository.findAll().forEach(patientEntity -> {
					System.out.println(patientEntity.getNom());
				});

			};
		}

	}





