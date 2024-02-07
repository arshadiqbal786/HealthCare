package com.health.care.controller;

import com.health.care.dto.HealthRecordDto;
import com.health.care.model.HealthRecord;
import com.health.care.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthRecords")
@PreAuthorize("hasRole('ADMIN')")

public class HealthRecordController {
    @Autowired
    private HealthRecordService healthRecordService;

    @PostMapping("/{userId}")
    public HealthRecord addHealthRecord(@PathVariable Long userId, @RequestBody HealthRecordDto healthRecordDto) {
        return healthRecordService.addHealthRecord(userId, healthRecordDto);
    }

    @GetMapping("/{userId}")
    public List<HealthRecord> getHealthRecords(@PathVariable Long userId) {
        return healthRecordService.getHealthRecords(userId);
    }
}