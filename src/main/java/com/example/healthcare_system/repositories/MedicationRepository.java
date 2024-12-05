package com.example.healthcare_system.repositories;

import com.example.healthcare_system.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    // Busca todos os medicamentos associados a um paciente
    List<Medication> findByPatientId(Long patientId);
}
