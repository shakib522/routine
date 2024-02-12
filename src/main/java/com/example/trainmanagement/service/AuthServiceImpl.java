package com.example.trainmanagement.service;


import com.example.trainmanagement.config.JwtService;
import com.example.trainmanagement.entity.User;
import com.example.trainmanagement.error.DefaultException;
import com.example.trainmanagement.model.RegisterRequest;
import com.example.trainmanagement.model.RegisterResponse;
import com.example.trainmanagement.model.Role;
import com.example.trainmanagement.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (authRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new DefaultException("Email already exist", HttpStatus.BAD_REQUEST.value());
        }
        val user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        authRepository.save(user);
        val jwtToken = jwtService.generateToken(user);
        return RegisterResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole().name())
                .name(user.getName())
                .build();
    }
}
