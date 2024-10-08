package com.example.routine.service;

import com.example.routine.error.DefaultMessage;
import com.example.routine.model.*;

public interface AuthService {

     RegisterResponse register(RegisterRequest registerRequest);
     LoginResponse login(LoginRequest loginRequest);
     DefaultMessage makeTeacher(MakeTeacher makeTeacher);
}
