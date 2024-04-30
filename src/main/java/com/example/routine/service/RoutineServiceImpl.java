package com.example.routine.service;

import com.example.routine.entity.Routine;
import com.example.routine.error.DefaultMessage;
import com.example.routine.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService{

    private final RoutineRepository repository;

    @Override
    public DefaultMessage createRoutine(Routine routineRequest) {
        repository.save(routineRequest);
        return DefaultMessage.builder()
                .statusCode(201)
                .status("created")
                .message("Routine created successfully")
                .build();
    }
}
