package com.example.routine.service;

import com.example.routine.entity.Routine;
import com.example.routine.error.DefaultMessage;

import java.util.List;

public interface RoutineService {
    DefaultMessage createRoutine(Routine routineRequest);
    List<Routine> getRoutineByYearAndDay(String day,Integer year);

    List<Routine> getRoutineByTeacher(String name);
}
