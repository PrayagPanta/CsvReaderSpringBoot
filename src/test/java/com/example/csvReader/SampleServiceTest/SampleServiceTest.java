package com.example.csvReader.SampleServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.repository.EmployeeRepository;
import com.example.csvReader.service.EmployeeService;
import com.example.csvReader.service.EmployeeServiceImplementation;

//NOTE:
//Sample Only not Fully Functional Test
/*
 * @RunWith(SpringRunner.class) public class SampleServiceTest {
 * 
 * @TestConfiguration static class EmployeeServiceImplTestContextConfiguration {
 * 
 * @Bean public EmployeeService employeeService() { return new
 * EmployeeServiceImplementation(employeeRepository); } }
 * 
 * @Autowired private EmployeeService employeeService;
 * 
 * @MockBean private static EmployeeRepository employeeRepository;
 * 
 * @Test public void getAllEmployeesWithoutSalary() { EmployeeDetails employee1
 * = new EmployeeDetails("ZeroSalary", "Employee", 20, "", "INTERN");
 * EmployeeDetails employee2 = new EmployeeDetails("ZeroSalary2", "Employee",
 * 25, "$0", "INTERN"); List<EmployeeDetails> employeeDetailsList = new
 * ArrayList<EmployeeDetails>() {{ add(employee1); add(employee2);} };
 * when(employeeRepository.findAllEmployeesWithoutSalary()).thenReturn(
 * employeeDetailsList);
 * assertEquals(employeeService.getEmployeeWithoutSalary(),employeeDetailsList);
 * } }
 */