package com.example.healthcare_system.services;

import com.example.healthcare_system.dtos.MedicalAppointmentDTO;
import com.example.healthcare_system.entities.MedicalAppointment;
import com.example.healthcare_system.entities.Patient;
import com.example.healthcare_system.exceptions.ResourceNotFoundException;
import com.example.healthcare_system.repositories.MedicalAppointmentRepository;
import com.example.healthcare_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Retorna todos os atendimentos médicos
    public List<MedicalAppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Retorna um atendimento médico pelo ID
    public MedicalAppointmentDTO getAppointmentById(Long id) {
        MedicalAppointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atendimento médico com ID " + id + " não encontrado."));
        return convertToDTO(appointment);
    }

    // Cria um novo atendimento médico
    public MedicalAppointment createAppointment(MedicalAppointmentDTO appointmentDTO) {
        MedicalAppointment appointment = convertToEntity(appointmentDTO);
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente com ID " + appointmentDTO.getPatientId() + " não encontrado."));
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }

    // Atualiza um atendimento médico existente
    public MedicalAppointment updateAppointment(Long id, MedicalAppointmentDTO appointmentDTO) {
        MedicalAppointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atendimento médico com ID " + id + " não encontrado."));
        existingAppointment.setDate(appointmentDTO.getDate());
        existingAppointment.setDoctorName(appointmentDTO.getDoctorName());
        existingAppointment.setDiagnosis(appointmentDTO.getDiagnosis());
        return appointmentRepository.save(existingAppointment);
    }

    // Exclui um atendimento médico
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Atendimento médico com ID " + id + " não encontrado.");
        }
        appointmentRepository.deleteById(id);
    }

    // Converte uma entidade para DTO
    private MedicalAppointmentDTO convertToDTO(MedicalAppointment appointment) {
        MedicalAppointmentDTO dto = new MedicalAppointmentDTO();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setDoctorName(appointment.getDoctorName());
        dto.setDiagnosis(appointment.getDiagnosis());
        dto.setPatientId(appointment.getPatient().getId());
        return dto;
    }

    // Converte um DTO para entidade
    private MedicalAppointment convertToEntity(MedicalAppointmentDTO dto) {
        MedicalAppointment appointment = new MedicalAppointment();
        appointment.setDate(dto.getDate());
        appointment.setDoctorName(dto.getDoctorName());
        appointment.setDiagnosis(dto.getDiagnosis());
        return appointment;
    }
}
