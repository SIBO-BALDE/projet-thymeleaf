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
				patientRepository.save(new PatientEntity(null ,"Hassane", new Date(),false,12));
				patientRepository.save(new PatientEntity(null ,"Hawa", new Date(),false,13));
				patientRepository.save(new PatientEntity(null ,"Bilal", new Date(),false,5));
				patientRepository.save(new PatientEntity(null ,"Zeynab", new Date(),false,22));
				patientRepository.save(new PatientEntity(null ,"Haby", new Date(),false,8));

				patientRepository.findAll().forEach(patientEntity -> {
					System.out.println(patientEntity.getNom());
				});

			};
		}

	}





