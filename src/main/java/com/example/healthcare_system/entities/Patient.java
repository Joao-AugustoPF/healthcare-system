package com.example.healthcare_system.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do paciente

    private String name; // Nome do paciente
    private int age;     // Idade do paciente

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medication> medications; // Lista de medicamentos associados ao paciente

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalAppointment> appointments; // Lista de atendimentos médicos do paciente
}
