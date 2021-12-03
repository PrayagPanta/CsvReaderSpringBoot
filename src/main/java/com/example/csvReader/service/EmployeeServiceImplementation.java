package com.example.csvReader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public List<EmployeeDetails> getEmployeeWithoutSalary() {
		return employeeRepository.findAllEmployeesWithoutSalary();
	}

	public List<EmployeeDetails> getEmployeesAboveAge(int age) {
		return employeeRepository.findAllByAgeGreaterThan(age);
	}

	public List<EmployeeDetails> getEmployeesAboveSalary(String salary) {
		return employeeRepository.findAllWhereIncomeGreaterThan(salary);
	}
}
