package com.example.csvReader.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.repository.EmployeeRepository;

@DataJpaTest
public class RepositoryTester {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void whenWithoutSalary_thenReturn2Employees() {
		// given
		EmployeeDetails employee1 = new EmployeeDetails("ZeroSalary", "Employee", 20, "", "INTERN");
		entityManager.persist(employee1);
		EmployeeDetails employee2 = new EmployeeDetails("ZeroSalary2", "Employee", 25, "$0", "INTERN");
		entityManager.persist(employee2);
		entityManager.flush();

		// when
		List<EmployeeDetails> employees = employeeRepository.findAllEmployeesWithoutSalary();

		// then
		assertThat(employees.size()).isEqualTo(2);
		assertEquals(employees.stream().filter(e -> e.getFirstName().equals("ZeroSalary")).collect(Collectors.toList())
				.get(0), employee1);
	}

	@Test
	public void whenAgeGreaterThan30_thenReturn1Employee() {
		// given
		EmployeeDetails employee1 = new EmployeeDetails("Sample", "Employee", 31, "$100", "INTERN");
		EmployeeDetails employee2 = new EmployeeDetails("Sample2", "Employee", 25, "$100", "INTERN");
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.flush();

		// when
		List<EmployeeDetails> employees = employeeRepository.findAllByAgeGreaterThan(30);

		// then
		assertThat(employees.get(0).equals(employee1));
	}

	@Test
	public void whenSalaryGreaterThan100_thenReturn1Employee() {
		// given
		EmployeeDetails employee1 = new EmployeeDetails("Sample", "Employee", 31, "$101", "INTERN");
		EmployeeDetails employee2 = new EmployeeDetails("Sample2", "Employee", 25, "$100", "INTERN");
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.flush();

		// when
		List<EmployeeDetails> employees = employeeRepository.findAllByAgeGreaterThan(30);

		// then
		assertThat(employees.get(0).equals(employee1));
	}
}
