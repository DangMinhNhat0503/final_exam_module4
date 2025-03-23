package com.example.final_exam_module4.repository;

import com.example.final_exam_module4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
