package com.health.care.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String medicationName;
    private String dosage;
    private String frequency;

    // getters and setters
}