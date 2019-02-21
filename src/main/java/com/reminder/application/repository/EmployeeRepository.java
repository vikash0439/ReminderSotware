package com.reminder.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.application.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 Employee findByName(String name);

}
