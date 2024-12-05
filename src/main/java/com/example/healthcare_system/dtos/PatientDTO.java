package com.example.healthcare_system.dtos;

import lombok.*;

@Data
public class PatientDTO {
    private Long id;        // Identificador do paciente
    private String name;    // Nome do paciente
    private int age;        // Idade do paciente
}
