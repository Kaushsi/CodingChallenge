package com.coding.excercise.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding.excercise.service.EmployeeService;

@RestController
public class CompanyController {

	@Autowired
	private EmployeeService service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/companyHierarchy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getAllEmployees() {
		String companyHierarchy = service.employeeHierarachy();
		
		if (StringUtils.isBlank(companyHierarchy)) {
			 return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<String>(companyHierarchy, HttpStatus.OK);
	}
}
