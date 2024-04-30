package com.example.routine.controller;


import com.example.routine.entity.Routine;
import com.example.routine.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TeacherController {

    private final RoutineService service;

    @GetMapping("/teacher/getAllRoutine/{name}")
    public ResponseEntity<List<Routine>> getRoutineByTeacher
            (@PathVariable("name")String name)
    {
        return ResponseEntity.status(200).body(service.getRoutineByTeacher(name));
    }
}
