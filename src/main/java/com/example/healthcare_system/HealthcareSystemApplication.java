package com.example.healthcare_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareSystemApplication.class, args);
		System.out.println("Healthcare System Application está rodando na porta: http://localhost:8080/");
	}

}
