package com.example.healthcare_system.controllers;

import com.example.healthcare_system.dtos.MedicationDTO;
import com.example.healthcare_system.entities.Medication;
import com.example.healthcare_system.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public List<MedicationDTO> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @GetMapping("/{id}")
    public MedicationDTO getMedicationById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

    @PostMapping
    public Medication createMedication(@RequestBody MedicationDTO medicationDTO) {
        return medicationService.createMedication(medicationDTO);
    }

    @PutMapping("/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody MedicationDTO medicationDTO) {
        return medicationService.updateMedication(id, medicationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
    }
}
