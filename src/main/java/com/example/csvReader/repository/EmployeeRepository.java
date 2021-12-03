package com.example.csvReader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.csvReader.entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
	@Query(value = "SELECT e FROM EmployeeDetails e WHERE e.Income IS '' OR e.Income = '$0' ")
	List<EmployeeDetails> findAllEmployeesWithoutSalary();

	@Query(value = "SELECT e FROM EmployeeDetails e WHERE e.Age > ?1 ")
	List<EmployeeDetails> findAllByAgeGreaterThan(int age);

	@Query(value = "SELECT e FROM EmployeeDetails e WHERE SUBSTRING(e.Income,2) > ?1 ")
	List<EmployeeDetails> findAllWhereIncomeGreaterThan(String salary);

}
