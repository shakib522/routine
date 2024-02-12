package com.example.trainmanagement.controller;


import com.example.trainmanagement.error.DefaultException;
import com.example.trainmanagement.model.RegisterRequest;
import com.example.trainmanagement.model.RegisterResponse;
import com.example.trainmanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws DefaultException {
        return ResponseEntity.status(201).body(authService.register(registerRequest));
    }
}
