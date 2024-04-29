package com.example.routine.repository;


import com.example.routine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "SELECT * from routine.user u where u.student_id = ?1",nativeQuery = true)
    Optional<User> findByStudentId(String student_id);
//    @Query(value="SELECT * FROM train.user u WHERE u.user_id = ?1",nativeQuery = true )
//    Optional<User> findUserById(Long Id);
}
