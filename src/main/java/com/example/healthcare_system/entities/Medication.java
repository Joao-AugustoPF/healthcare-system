package com.example.healthcare_system.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do medicamento

    private String name;      // Nome do medicamento
    private String dosage;    // Dosagem do medicamento (ex.: "50mg")
    private String frequency; // Frequência de uso (ex.: "1 vez ao dia")

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; // Referência ao paciente associado
}
