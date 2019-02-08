package com.reminder.application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.application.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}