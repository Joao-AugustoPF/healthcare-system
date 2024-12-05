package com.example.healthcare_system.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do atendimento médico

    private LocalDate date;    // Data do atendimento médico
    private String doctorName; // Nome do médico responsável
    private String diagnosis;  // Diagnóstico do atendimento

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; // Referência ao paciente associado
}
