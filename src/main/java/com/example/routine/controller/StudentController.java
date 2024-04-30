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
public class StudentController {
    private final RoutineService service;

    @GetMapping("/getAllRoutine/{year}/{day}")
    public ResponseEntity<List<Routine>> getRoutineByDayAndYear
            (@PathVariable("year")Integer year,@PathVariable("day")String day)
    {
        return ResponseEntity.status(200).body(service.getRoutineByYearAndDay(day,year));
    }

}
