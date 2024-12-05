package com.example.healthcare_system.dtos;

import lombok.*;

@Data
public class MedicationDTO {
    private Long id;         // Identificador do medicamento
    private String name;     // Nome do medicamento
    private String dosage;   // Dosagem (ex.: "50mg")
    private String frequency; // Frequência (ex.: "1 vez ao dia")
    private Long patientId;  // ID do paciente relacionado
}