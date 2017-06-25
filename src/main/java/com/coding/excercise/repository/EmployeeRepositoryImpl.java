package com.coding.excercise.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coding.excercise.domain.Employee;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> findAllEmployees() {
		return getEmployers();
	}

	private List<Employee> getEmployers() {
		List<Employee> employees  = new ArrayList<>();
		employees.add(new Employee(150, "Jamie", null));
		employees.add(new Employee(100, "Alan", 150));
		employees.add(new Employee(220, "Martin", 100));
		employees.add(new Employee(275, "Alex", 100));
		employees.add(new Employee(400, "Steve", 150));
		employees.add(new Employee(190, "David", 400));
		return employees;
	}
	 
}
