package com.barisozkan.services;

import java.util.List;

import com.barisozkan.dto.DtoCustomer;
import com.barisozkan.dto.DtoCustomerIU;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Long id);
	
	public DtoCustomer saveCustomer(DtoCustomerIU customerIU);
	
	public void deleteCustomer(Long id);
	
	public List<DtoCustomer> getAllCustomer();
	
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);
	
}
