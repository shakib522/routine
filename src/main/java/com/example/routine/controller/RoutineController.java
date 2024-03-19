package com.example.routine.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RoutineController {



    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Routine Management System";
    }

}