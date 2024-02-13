package com.example.trainmanagement.controller;

import com.example.trainmanagement.entity.Profile;
import com.example.trainmanagement.error.DefaultException;
import com.example.trainmanagement.service.profileService.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TrainController {

    private final ProfileService profileService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Train Management System";
    }

    @PostMapping("/users")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) throws DefaultException {
        return ResponseEntity.status(201).body(profileService.createProfile(profile));
    }
}