package com.example.healthcare_system.repositories;

import com.example.healthcare_system.entities.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
    // Busca todos os atendimentos médicos associados a um paciente
    List<MedicalAppointment> findByPatientId(Long patientId);
}