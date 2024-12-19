package com.barisozkan.services;

import java.util.List;

import com.barisozkan.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> findAllEmployee();
}
