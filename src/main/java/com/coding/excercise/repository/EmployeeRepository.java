package com.coding.excercise.repository;

import java.util.List;

import com.coding.excercise.domain.Employee;

public interface EmployeeRepository {
	 List<Employee> findAllEmployees();
}
