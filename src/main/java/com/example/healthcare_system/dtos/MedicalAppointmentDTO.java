package com.example.healthcare_system.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
public class MedicalAppointmentDTO {
    private Long id;          // Identificador do atendimento médico
    private LocalDate date;   // Data do atendimento
    private String doctorName; // Nome do médico responsável
    private String diagnosis;  // Diagnóstico do atendimento
    private Long patientId;   // ID do paciente relacionado
}