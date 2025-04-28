package com.example.mdbspringboot;

import java.time.LocalDate;
import java.util.List;

import com.example.mdbspringboot.model.Injection;
import com.example.mdbspringboot.model.TreatmentEntry;
import com.example.mdbspringboot.repository.TreatmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

	@Autowired
	TreatmentRepository treatmentRepo;

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}

	public void run(String... args) {
		treatmentRepo.deleteAll();
		createStructuredData();
		showAll();
	}

	void createStructuredData() {
		System.out.println("Creating structured treatment entry...");

		Injection injection = new Injection();
		injection.setDrop(9);
		injection.setBlood_vessel(3);
		injection.setMuscle(2);
		injection.setInside_skin(0);
		injection.setUnder_skin(0);

		TreatmentEntry entry = new TreatmentEntry();
		entry.setDate(LocalDate.of(2025, 2, 3));
		entry.setInjection(injection);
		entry.setUHF_machine(5);
		entry.setMassage_chair(1);
		entry.setRed_light(3);
		entry.setUltrasound(5);
		entry.setLaser(0);
		entry.setBiotens(6);
		entry.setLymphatic_drainage_massage(0);
		entry.setElectrophoresis(1);
		entry.setMicro_cupping(0);
		entry.setOxygen(0);
		entry.setSurgical_bandage(0);

		treatmentRepo.save(entry);
	}

	void showAll() {
		List<TreatmentEntry> list = treatmentRepo.findAll();
		for (TreatmentEntry entry : list) {
			System.out.println("Date: " + entry.getDate());
			System.out.println("Injection - drop: " + entry.getInjection().getDrop());
			System.out.println("UHF Machine: " + entry.getUHF_machine());
			System.out.println("Massage Chair: " + entry.getMassage_chair());
			System.out.println("Red Light: " + entry.getRed_light());
			// Add more if needed
		}
	}

    @Bean
    WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
