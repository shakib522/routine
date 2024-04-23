package com.example.routine.controller;


import com.example.routine.error.DefaultException;
import com.example.routine.model.LoginRequest;
import com.example.routine.model.LoginResponse;
import com.example.routine.model.RegisterRequest;
import com.example.routine.model.RegisterResponse;
import com.example.routine.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws DefaultException {
        return ResponseEntity.status(201).body(authService. register(registerRequest));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws DefaultException{
        return ResponseEntity.status(200).body(authService.login(loginRequest));
    }
}
