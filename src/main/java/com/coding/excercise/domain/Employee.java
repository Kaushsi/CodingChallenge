package com.coding.excercise.domain;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	private final Integer id;
	private final String name;
	private final Integer managerId;
	
	private Set<Employee> subordinates = new HashSet<Employee>();
	
	public Employee(Integer id, String name, Integer managerId) {
		this.id = id;
		this.name = name;
		this.managerId = managerId;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public boolean isCEO() {
		return this.managerId == null;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * id.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee emp = (Employee) obj;
		return emp.getId().equals(this.getId());
	}
	
	
}
