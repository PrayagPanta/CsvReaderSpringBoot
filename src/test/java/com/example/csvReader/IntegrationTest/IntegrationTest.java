package com.example.csvReader.IntegrationTest;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.repository.EmployeeRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private EmployeeRepository repository;

	@Test
	public void givenEmployees_whenGetEmployeesAboveSalary3000_thenStatus200() throws Exception {
		mvc.perform(get("/employeesAboveSalary/3000").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$", hasSize(2)))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void givenEmployees_whenGetEmployeesAboveAge30_thenStatus200() throws Exception {
		mvc.perform(get("/employeesAboveAge/30").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$", hasSize(2)))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void givenEmployees_whenGetEmployeesWithoutSalary_thenStatus200() throws Exception {
		// Case Income column null
		repository.save(new EmployeeDetails("ZeroSalary", "Employee", 20, "", "INTERN"));
		// Case Income column contains $0
		repository.save(new EmployeeDetails("ZeroSalary2", "Employee", 25, "$0", "INTERN"));
		mvc.perform(get("/employeeWithoutSalary").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$", hasSize(2)))
				.andDo(MockMvcResultHandlers.print());
	}
}
