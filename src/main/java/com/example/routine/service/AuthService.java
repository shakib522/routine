package com.example.routine.service;

import com.example.routine.model.LoginRequest;
import com.example.routine.model.LoginResponse;
import com.example.routine.model.RegisterRequest;
import com.example.routine.model.RegisterResponse;

public interface AuthService {

     RegisterResponse register(RegisterRequest registerRequest);
     LoginResponse login(LoginRequest loginRequest);

}
