package com.reminder.application.service;

import com.reminder.application.model.Employee;

public interface EmployeeService {
	
	void save(Employee employee);
	
	Employee findByName(String name);

}
