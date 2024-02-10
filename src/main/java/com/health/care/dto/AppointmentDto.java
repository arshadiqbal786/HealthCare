package com.health.care.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    private LocalDateTime appointmentDateTime;
    private String doctorName;
    private String doctorSpecialization;
    private String location;
    private String notes;

    public AppointmentDto() {
        // Set appointmentDateTime to the current date and time when the object is created
        this.appointmentDateTime = LocalDateTime.now();
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
