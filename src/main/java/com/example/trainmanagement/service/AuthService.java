package com.example.trainmanagement.service;

import com.example.trainmanagement.model.RegisterRequest;
import com.example.trainmanagement.model.RegisterResponse;

public interface AuthService {

     RegisterResponse register(RegisterRequest registerRequest);

}
