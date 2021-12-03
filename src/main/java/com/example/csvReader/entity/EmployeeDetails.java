package com.example.csvReader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer Id;

	@CsvBindByPosition(position = 0)
	@Column(name = "FirstName")
	private String FirstName;

	@CsvBindByPosition(position = 1)
	@Column(name = "LastName")
	private String LastName;

	@CsvBindByPosition(position = 2)
	@Column(name = "Age")
	private Integer Age;

	@Column(name = "Income")
	@CsvBindByPosition(position = 3)
	private String Income;

	@Column(name = "Department")
	@CsvBindByPosition(position = 4)
	private String Department;

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(String firstName, String lastName, Integer age, String income, String department) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Income = income;
		Department = department;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getIncome() {
		return Income;
	}

	public void setIncome(String income) {
		Income = income;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

}
