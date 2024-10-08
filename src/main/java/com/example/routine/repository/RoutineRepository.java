package com.example.routine.repository;


import com.example.routine.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    @Query(value = "SELECT * FROM routine.routine r where r.day=?1 and r.year=?2 ", nativeQuery = true)
    List<Routine> getRoutineByDayAndYear(String day, Integer year);

    @Query(value = "SELECT * FROM routine.routine r where r.course_teacher LIKE CONCAT(?1, '%')", nativeQuery = true)
    List<Routine> getRoutineByTeacher(String name);

    @Query(value = "SELECT * FROM routine.routine r where r.day=?1 order by r.year , r.start_time , r.end_time desc", nativeQuery = true)
    List<Routine> getRoutineByDay(String day);

}
