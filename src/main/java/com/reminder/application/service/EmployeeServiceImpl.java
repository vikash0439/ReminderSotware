package com.reminder.application.service;

import org.springframework.stereotype.Service;

import com.reminder.application.model.Employee;
import com.reminder.application.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);

	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
	}

}
