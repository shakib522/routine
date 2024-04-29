package com.example.routine.service;


import com.example.routine.config.JwtService;
import com.example.routine.entity.User;
import com.example.routine.error.DefaultException;
import com.example.routine.error.DefaultMessage;
import com.example.routine.model.*;
import com.example.routine.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (authRepository.findByStudentId(registerRequest.getStudent_id()).isPresent()) {
            throw new DefaultException("The associated id already exist", HttpStatus.BAD_REQUEST.value());
        }
        val user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .student_id(registerRequest.getStudent_id())
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
                .student_id(user.getStudent_id())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        val user = authRepository.findByEmail(loginRequest.getEmail());
        if (user.isEmpty()) {
            throw new DefaultException("User not found with this student id", 404);
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            throw new DefaultException("Password is incorrect", HttpStatus.BAD_REQUEST.value());
        }
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword(),
                user.get().getAuthorities()
        ));
        val jwtToken = jwtService.generateToken(user.get());
        return LoginResponse.builder()
                .token(jwtToken)
                .user_id(user.get().getUser_id())
                .role(user.get().getRole().name())
                .student_id(user.get().getStudent_id())
                .name(user.get().getName())
                .build();
    }

    @Override
    public DefaultMessage makeTeacher(MakeTeacher makeTeacher) {
        val userOptional = authRepository.findByEmail(makeTeacher.getEmail());
        if (userOptional.isEmpty()) {
            throw new DefaultException("User not found with this email", HttpStatus.NOT_FOUND.value());
        }
        val user = userOptional.get();
        user.setRole(Role.valueOf(makeTeacher.getRole()));
        authRepository.save(user);
        return DefaultMessage.builder()
                .message("Teacher Added")
                .status("Success")
                .statusCode(200)
                .build();
    }
}
