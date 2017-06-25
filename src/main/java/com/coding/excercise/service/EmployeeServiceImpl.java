package com.coding.excercise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.excercise.domain.Employee;
import com.coding.excercise.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public String employeeHierarachy() {
		List<Employee> employees = repo.findAllEmployees();
		
		Employee  ceo = null;
		Map<Integer, List<Employee>> map = new HashMap<>();
		for (Employee employee : employees) {
			if (employee.isCEO()) {
				ceo = employee;
			} else {
				getManagerToEmployees(map, employee);
			}
		}
		StringBuilder builder = getCompanyHierarchy(ceo, map);
		return builder.toString();
	}


	private void getManagerToEmployees(Map<Integer, List<Employee>> map, Employee employee) {
		List<Employee> subs = map.get(employee.getManagerId());
		if (subs == null) {
			subs = new ArrayList<>();
			subs.add(employee);
		} else {
			subs.add(employee);
		}
		map.put(employee.getManagerId(), subs);
	}


	private StringBuilder getCompanyHierarchy(Employee ceo, Map<Integer, List<Employee>> map) {
		StringBuilder builder = new StringBuilder();
		builder.append(ceo.getName());
		List<Employee> managers = map.get(ceo.getId());
		for (Employee employee : managers) {
			builder.append( "\n" +"     ");
			builder.append(employee.getName());
			addHierarchy(employee, builder, map);
		}
		return builder;
	}
	
	private void addHierarchy(Employee employee, StringBuilder builder, Map<Integer, List<Employee>> map) {
		
		List<Employee> subordinates = map.get(employee.getId());
		if (subordinates != null) {
			for (Employee sub : subordinates) {
				builder.append("\n" + "          ");
				builder.append(sub.getName());
				employee = sub;
				addHierarchy(employee, builder, map);
			}
		}
	}
	
}
