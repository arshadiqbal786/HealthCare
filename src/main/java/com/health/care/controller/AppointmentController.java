package com.health.care.controller;

import com.health.care.dto.AppointmentDto;
import com.health.care.model.Appointment;
import com.health.care.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@PreAuthorize("hasRole('ADMIN')")

public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{userId}")
    public Appointment scheduleAppointment(@PathVariable Long userId, @RequestBody AppointmentDto appointmentDto) {
        return appointmentService.scheduleAppointment(userId, appointmentDto);
    }

    @GetMapping("/{userId}")
    public List<Appointment> getAppointments(@PathVariable Long userId) {
        return appointmentService.getAppointments(userId);
    }
}
