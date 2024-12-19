package com.barisozkan.controller;

import java.util.List;

import com.barisozkan.dto.DtoCustomer;
import com.barisozkan.dto.DtoCustomerIU;

public interface ICustomerController {
	
	public DtoCustomer findCustomerById(Long id);
	
	public DtoCustomer saveCustomer(DtoCustomerIU customerIU);
	
	public void deleteCustomer(Long id);
	
	public List<DtoCustomer> getAllCustomer();
	
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);
}
