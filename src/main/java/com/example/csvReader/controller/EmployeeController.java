package com.example.csvReader.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.csvReader.service.EmployeeService;

@RestController
public class EmployeeController {

	EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// Available End Points
	@GetMapping("/")
	public ResponseEntity<?> welcome() {
		return ResponseEntity.ok(
				"Welcome to CustomerManagementSystemAPI.End Points: /employeeWithoutSalary, /employeesAboveAge/{Age} and /employeesAboveSalary/{Salary}");
	}

	// Get All Employees Without Salary
	@GetMapping("/employeeWithoutSalary")
	public ResponseEntity<?> employeesWithoutSalary() {
		return ResponseEntity.ok(employeeService.getEmployeeWithoutSalary());
	}

	// Get All Employees whose age is greater than Age provided in URI
	@GetMapping("/employeesAboveAge/{Age}")
	public ResponseEntity<?> employeeAboveAge(@PathVariable("Age") @Min(18) Integer Age) {
		return ResponseEntity.ok(employeeService.getEmployeesAboveAge(Age));
	}

	// Accepts Salary both with and without the Dollar symbol
	@GetMapping("/employeesAboveSalary/{Salary}")
	public ResponseEntity<?> employeeAboveSalary(@PathVariable("Salary") String Salary) {
		return ResponseEntity
				.ok(employeeService.getEmployeesAboveSalary((Salary.startsWith("$") ? Salary.substring(1) : Salary)));
	}
}
