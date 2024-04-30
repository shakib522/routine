package com.example.routine.controller;

import com.example.routine.entity.Routine;
import com.example.routine.error.DefaultMessage;
import com.example.routine.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Routine Management System";
    }

    @PostMapping("/admin/createRoutine")
    public ResponseEntity<DefaultMessage> createRoutine(@RequestBody Routine routineRequest){
        return ResponseEntity.status(201).body(routineService.createRoutine(routineRequest));
    }

}