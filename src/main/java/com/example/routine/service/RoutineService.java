package com.example.routine.service;

import com.example.routine.entity.Routine;
import com.example.routine.error.DefaultMessage;

public interface RoutineService {
    DefaultMessage createRoutine(Routine routineRequest);
}
