package com.barisozkan.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barisozkan.controller.IEmployeeController;
import com.barisozkan.dto.DtoEmployee;
import com.barisozkan.services.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController{
	
	@Autowired
	private IEmployeeService employeeService;

	@Override
	@GetMapping("/list")
	public List<DtoEmployee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

}
