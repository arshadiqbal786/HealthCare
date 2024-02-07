package com.health.care.service;

import com.health.care.dto.MedicationDto;
import com.health.care.model.Medication;
import com.health.care.model.User;
import com.health.care.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

    public Medication addMedication(Long userId, MedicationDto medicationDto) {
        // You can implement logic to validate data and create a new Medication entity
        User user = new User();
        user.setId(userId);  // Assuming you have a UserService to retrieve the user

        Medication medication = new Medication();
        medication.setUser(user);
        medication.setMedicationName(medicationDto.getMedicationName());
        medication.setDosage(medicationDto.getDosage());
        medication.setFrequency(medicationDto.getFrequency());

        return medicationRepository.save(medication);
    }

    public List<Medication> getMedications(Long userId) {
        // You can implement logic to retrieve all medications for a user
        return medicationRepository.findAllByUserId(userId);
    }
}
