package com.example.routine.service;

import com.example.routine.entity.Routine;
import com.example.routine.error.DefaultMessage;
import com.example.routine.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Routine> getRoutineByYearAndDay(String day, Integer year) {
        return repository.getRoutineByDayAndYear(day,year);
    }

    @Override
    public List<Routine> getRoutineByTeacher(String name) {
        return repository.getRoutineByTeacher(name);
    }

    @Override
    public DefaultMessage editRoutine(Routine routineRequest, Long id) {
        Routine routine = repository.findById(id).get();
        routine.setCourse_code(routineRequest.getCourse_code());
        routine.setCourse_name(routineRequest.getCourse_name());
        routine.setCourse_teacher(routineRequest.getCourse_teacher());
        routine.setDay(routineRequest.getDay());
        routine.setEnd_time(routineRequest.getEnd_time());
        routine.setStart_time(routineRequest.getStart_time());
        routine.setYear(routineRequest.getYear());
        repository.save(routine);
        return DefaultMessage.builder()
                .statusCode(200)
                .status("ok")
                .message("Routine updated successfully")
                .build();
    }

    @Override
    public List<Routine> getAllRoutineByDay(String day) {
        return repository.getRoutineByDay(day);
    }
}
