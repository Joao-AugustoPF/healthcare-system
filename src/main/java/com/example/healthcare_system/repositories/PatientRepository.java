package com.example.healthcare_system.repositories;

import com.example.healthcare_system.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Métodos personalizados podem ser adicionados aqui se necessário
}
