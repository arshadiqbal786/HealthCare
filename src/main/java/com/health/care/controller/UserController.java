package com.health.care.controller;
import com.health.care.dto.UserDto;
import com.health.care.model.Role;
import com.health.care.model.User;
import com.health.care.repository.RoleRepository;
import com.health.care.repository.UserRepository;
import com.health.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;




@PostMapping("/register")
public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {

    if(userRepository.existsByUsername(userDto.getUsername())){
        return new ResponseEntity<>("Username is already taken!",
                HttpStatus.BAD_REQUEST);
    }
    // add check for email exists in DB
    if(userRepository.existsByEmail(userDto.getEmail())){
        return new ResponseEntity<>("Email is already taken!",
                HttpStatus.BAD_REQUEST);
    }
    // create user object
    User user = new User();
    user.setName(userDto.getName());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setDateOfBirth(userDto.getDateOfBirth());
    user.setGender(userDto.getGender());
    user.setContactNumber(userDto.getContactNumber());
    Role roles = roleRepository.findByName("ROLE_USER").get();
    user.setRoles(Collections.singleton(roles));
    userRepository.save(user);
    return new ResponseEntity<>("User registered successfully",
            HttpStatus.OK);
}


@GetMapping("/{userId}")
@PreAuthorize("hasRole('ADMIN')")
public User getUserById(@PathVariable Long userId) {
    return userService.getUserById(userId);
}

@PutMapping("/{userId}")
@PreAuthorize("hasRole('ADMIN')")
public User updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
    return userService.updateUser(userId, userDto);
}
}
