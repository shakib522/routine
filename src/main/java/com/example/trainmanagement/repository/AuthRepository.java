package com.example.trainmanagement.repository;


import com.example.trainmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

//    @Query(value="SELECT * FROM train.user u WHERE u.user_id = ?1",nativeQuery = true )
//    Optional<User> findUserById(Long Id);
}
