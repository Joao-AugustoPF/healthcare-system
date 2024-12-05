package com.example.healthcare_system.controllers;

import com.example.healthcare_system.dtos.MedicalAppointmentDTO;
import com.example.healthcare_system.entities.MedicalAppointment;
import com.example.healthcare_system.services.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService appointmentService;

    @GetMapping
    public List<MedicalAppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public MedicalAppointmentDTO getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public MedicalAppointment createAppointment(@RequestBody MedicalAppointmentDTO appointmentDTO) {
        return appointmentService.createAppointment(appointmentDTO);
    }

    @PutMapping("/{id}")
    public MedicalAppointment updateAppointment(@PathVariable Long id, @RequestBody MedicalAppointmentDTO appointmentDTO) {
        return appointmentService.updateAppointment(id, appointmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
