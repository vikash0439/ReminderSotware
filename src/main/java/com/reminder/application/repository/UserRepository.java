package com.reminder.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
