package com.coding.excercise.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.coding.excercise.config.Application;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@Configuration
@SpringBootTest(classes = Application.class)
@TestConfiguration
public class EmployeeServiceImplIntegrationTest  {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testEmployeeHierarchy() {
		String employeeHierarachy = employeeService.employeeHierarachy();
		assertNotNull(employeeHierarachy);
		assertTrue(employeeHierarachy.contains("Jamie"));
		assertTrue(employeeHierarachy.contains("Alan"));
		assertTrue(employeeHierarachy.contains("Martin"));
		assertTrue(employeeHierarachy.contains("Alex"));
		assertTrue(employeeHierarachy.contains("Steve"));
		assertTrue(employeeHierarachy.contains("David"));
	}
}
