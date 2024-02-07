package com.health.care.dto;

import com.health.care.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String contactNumber;

    // getters and setters
}
