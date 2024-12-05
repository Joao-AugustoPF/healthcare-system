package com.example.healthcare_system.services;

import com.example.healthcare_system.dtos.PatientDTO;
import com.example.healthcare_system.entities.Patient;
import com.example.healthcare_system.exceptions.ResourceNotFoundException;
import com.example.healthcare_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Retorna todos os pacientes
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retorna um paciente pelo ID
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID " + id + " não encontrado."));
        return convertToDTO(patient);
    }

    // Cria um novo paciente
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        return patientRepository.save(patient);
    }

    // Atualiza um paciente existente
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID " + id + " não encontrado."));
        existingPatient.setName(patientDTO.getName());
        existingPatient.setAge(patientDTO.getAge());
        return patientRepository.save(existingPatient);
    }

    // Exclui um paciente
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente com ID " + id + " não encontrado.");
        }
        patientRepository.deleteById(id);
    }

    // Converte uma entidade para DTO
    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setAge(patient.getAge());
        return dto;
    }

    // Converte um DTO para entidade
    private Patient convertToEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        return patient;
    }
}
