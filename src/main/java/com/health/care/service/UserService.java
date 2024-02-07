package com.health.care.service;

import com.health.care.dto.UserDto;
import com.health.care.model.User;
import com.health.care.repository.UserRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto userDto) {
        // You can implement logic to validate data and create a new User entity
        User existingUser = userRepository.findByUsername(userDto.getUsername()).orElse(null);
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // You should hash the password for security
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setGender(userDto.getGender());
        user.setContactNumber(userDto.getContactNumber());

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        // You can implement logic to retrieve a user by ID
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    public User updateUser(Long userId, UserDto userDto) {
        // You can implement logic to update user information
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        // Update user fields based on userDto
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setGender(userDto.getGender());
        user.setContactNumber(userDto.getContactNumber());

        return userRepository.save(user);
    }
}

