package com.health.care.model;
import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate recordDate;
    private Double weight;
    private Double height;
    private String bloodPressure;

    // getters and setters
}