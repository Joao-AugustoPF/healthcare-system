package com.example.healthcare_system.services;

import com.example.healthcare_system.dtos.MedicationDTO;
import com.example.healthcare_system.entities.Medication;
import com.example.healthcare_system.entities.Patient;
import com.example.healthcare_system.exceptions.ResourceNotFoundException;
import com.example.healthcare_system.repositories.MedicationRepository;
import com.example.healthcare_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Retorna todos os medicamentos
    public List<MedicationDTO> getAllMedications() {
        return medicationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retorna um medicamento pelo ID
    public MedicationDTO getMedicationById(Long id) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento com ID " + id + " não encontrado."));
        return convertToDTO(medication);
    }

    // Cria um novo medicamento
    public Medication createMedication(MedicationDTO medicationDTO) {
        Medication medication = convertToEntity(medicationDTO);
        Patient patient = patientRepository.findById(medicationDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID " + medicationDTO.getPatientId() + " não encontrado."));
        medication.setPatient(patient);
        return medicationRepository.save(medication);
    }

    // Atualiza um medicamento existente
    public Medication updateMedication(Long id, MedicationDTO medicationDTO) {
        Medication existingMedication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento com ID " + id + " não encontrado."));
        existingMedication.setName(medicationDTO.getName());
        existingMedication.setDosage(medicationDTO.getDosage());
        existingMedication.setFrequency(medicationDTO.getFrequency());
        return medicationRepository.save(existingMedication);
    }

    // Exclui um medicamento
    public void deleteMedication(Long id) {
        if (!medicationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Medicamento com ID " + id + " não encontrado.");
        }
        medicationRepository.deleteById(id);
    }

    // Converte uma entidade para DTO
    private MedicationDTO convertToDTO(Medication medication) {
        MedicationDTO dto = new MedicationDTO();
        dto.setId(medication.getId());
        dto.setName(medication.getName());
        dto.setDosage(medication.getDosage());
        dto.setFrequency(medication.getFrequency());
        dto.setPatientId(medication.getPatient().getId());
        return dto;
    }

    // Converte um DTO para entidade
    private Medication convertToEntity(MedicationDTO dto) {
        Medication medication = new Medication();
        medication.setName(dto.getName());
        medication.setDosage(dto.getDosage());
        medication.setFrequency(dto.getFrequency());
        return medication;
    }
}
