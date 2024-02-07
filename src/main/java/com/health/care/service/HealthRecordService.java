package com.health.care.service;

import com.health.care.dto.HealthRecordDto;
import com.health.care.model.HealthRecord;
import com.health.care.model.User;
import com.health.care.repository.HealthRecordRepository;
import com.health.care.repository.UserRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordService {
    @Autowired
    private HealthRecordRepository healthRecordRepository;

    @Autowired
    private UserRepository userRepository;

    public HealthRecord addHealthRecord(Long userId, HealthRecordDto healthRecordDto) {
        // You can implement logic to validate data and create a new HealthRecord entity
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setUser(user);
        healthRecord.setRecordDate(healthRecordDto.getRecordDate());
        healthRecord.setWeight(healthRecordDto.getWeight());
        healthRecord.setHeight(healthRecordDto.getHeight());
        healthRecord.setBloodPressure(healthRecordDto.getBloodPressure());

        return healthRecordRepository.save(healthRecord);
    }

    public List<HealthRecord> getHealthRecords(Long userId) {
        // You can implement logic to retrieve all health records for a user
        return healthRecordRepository.findAllByUserId(userId);
    }
}
