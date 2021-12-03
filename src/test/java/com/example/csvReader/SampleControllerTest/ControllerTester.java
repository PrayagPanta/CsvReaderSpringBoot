package com.example.csvReader.SampleControllerTest;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.csvReader.entity.EmployeeDetails;
import com.example.csvReader.service.EmployeeService;

//Note Sample Only
//Note Sample Only 

@WebMvcTest(ControllerTester.class)
public class ControllerTester {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private static EmployeeService employeeService;

	@Test
	public void getAllEmployeesWithoutSalary() throws Exception {
		EmployeeDetails employee1 = new EmployeeDetails("ZeroSalary", "Employee", 20, "", "INTERN");
		EmployeeDetails employee2 = new EmployeeDetails("ZeroSalary2", "Employee", 25, "$0", "INTERN");
		List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>() {
			{
				add(employee1);
				add(employee2);
			}
		};
		when(employeeService.getEmployeeWithoutSalary()).thenReturn(employeeDetailsList);
		mockMvc.perform(get("/employeeWithoutSalary").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty()).andExpect(jsonPath("$", hasSize(2)))
				.andDo(MockMvcResultHandlers.print());
	}
}
