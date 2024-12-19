package com.barisozkan.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barisozkan.controller.ICustomerController;
import com.barisozkan.dto.DtoCustomer;
import com.barisozkan.dto.DtoCustomerIU;
import com.barisozkan.services.ICustomerService;

@RestController
@RequestMapping("rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{

	@Autowired
	private ICustomerService customerService;
	
	@Override
	@GetMapping(path = "/list/{id}")
	public DtoCustomer findCustomerById(@PathVariable(name = "id", required = true) Long id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping(path = "/save")
	@Override
	public DtoCustomer saveCustomer(@RequestBody DtoCustomerIU customerIU) {
		return customerService.saveCustomer(customerIU);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteCustomer(@PathVariable(name = "id") Long id) {
		customerService.deleteCustomer(id);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoCustomer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoCustomer updateCustomer(@PathVariable(name = "id") Long id, @RequestBody DtoCustomerIU dtoCustomerIU) {
		return customerService.updateCustomer(id, dtoCustomerIU);
	}

}
