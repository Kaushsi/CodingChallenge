package com.coding.excercise.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coding.excercise.domain.Employee;
import com.coding.excercise.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest  {

	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private EmployeeRepository employeeRepo;
	
	
	@Test
	public void testEmployeeWithInvlidMangerId() {
		
		List<Employee> employees  = new ArrayList<>();
		employees.add(new Employee(150, "Jamie", null));
		employees.add(new Employee(100, "Alan", 150));
		employees.add(new Employee(220, "Martin", 100));
		employees.add(new Employee(221, "InvalidManager", 50));
		
		when(employeeRepo.findAllEmployees()).thenReturn(employees);
		String employeeHierarchy = employeeService.employeeHierarachy();
		
		assertNotNull(employeeHierarchy);
		assertTrue(employeeHierarchy.contains("Jamie"));
		assertTrue(employeeHierarchy.contains("Alan"));
		assertTrue(employeeHierarchy.contains("Martin"));
		
		assertFalse(employeeHierarchy.contains("InvalidManager"));
	}
	
	@Test
	public void testCompanyStruture() {
		
		List<Employee> employees  = new ArrayList<>();
		employees.add(new Employee(150, "Jamie", null));
		employees.add(new Employee(100, "Alan", 150));
		employees.add(new Employee(220, "Martin", 100));
		employees.add(new Employee(221, "John", 220));
		employees.add(new Employee(223, "Jason", 150));
		employees.add(new Employee(221, "Tim", 223));
		
		when(employeeRepo.findAllEmployees()).thenReturn(employees);
		String employeeHierarchy = employeeService.employeeHierarachy();
		assertNotNull(employeeHierarchy);
		assertTrue(employeeHierarchy.contains("Jamie"));
		assertTrue(employeeHierarchy.contains("Alan"));
		assertTrue(employeeHierarchy.contains("Martin"));
		assertTrue(employeeHierarchy.contains("John"));
		assertTrue(employeeHierarchy.contains("Jason"));
		assertTrue(employeeHierarchy.contains("Tim"));
	}
}
