package com.health.care.service;

import com.health.care.dto.AppointmentDto;
import com.health.care.model.Appointment;
import com.health.care.model.User;
import com.health.care.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment scheduleAppointment(Long userId, AppointmentDto appointmentDto) {
        // You can implement logic to validate data and create a new Appointment entity
        User user = new User();
        user.setId(userId);  // Assuming you have a UserService to retrieve the user

        Appointment appointment = new Appointment();
        appointment.setUser(user);
        appointment.setAppointmentDateTime(appointmentDto.getAppointmentDateTime());
        appointment.setLocation(appointmentDto.getLocation());
        appointment.setNotes(appointmentDto.getNotes());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointments(Long userId) {
        // You can implement logic to retrieve all appointments for a user
        return appointmentRepository.findAllByUserId(userId);
    }
}
