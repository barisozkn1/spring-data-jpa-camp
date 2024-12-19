package com.barisozkan.controller;

import java.util.List;

import com.barisozkan.dto.DtoEmployee;

public interface IEmployeeController {

	public List<DtoEmployee> findAllEmployee();
	
}
