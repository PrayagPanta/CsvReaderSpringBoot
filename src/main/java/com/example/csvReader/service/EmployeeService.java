package com.example.csvReader.service;

import java.util.List;

import com.example.csvReader.entity.EmployeeDetails;

public interface EmployeeService {
	public List<EmployeeDetails> getEmployeeWithoutSalary();

	public List<EmployeeDetails> getEmployeesAboveAge(int age);

	public List<EmployeeDetails> getEmployeesAboveSalary(String salary);
}
