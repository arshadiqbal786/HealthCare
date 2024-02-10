package com.health.care.controller;

import com.health.care.dto.MedicationDto;
import com.health.care.model.Medication;
import com.health.care.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@PreAuthorize("hasRole('ADMIN')")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Medication addMedication(@PathVariable Long userId, @RequestBody MedicationDto medicationDto) {
        return medicationService.addMedication(userId, medicationDto);
    }

    @GetMapping("/{userId}")
    public List<Medication> getMedications(@PathVariable Long userId) {
        return medicationService.getMedications(userId);
    }
}
