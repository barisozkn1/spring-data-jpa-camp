package com.barisozkan.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barisozkan.dto.DtoAddress;
import com.barisozkan.dto.DtoCustomer;
import com.barisozkan.dto.DtoCustomerIU;
import com.barisozkan.entites.Address;
import com.barisozkan.entites.Customer;
import com.barisozkan.repository.AddressRepository;
import com.barisozkan.repository.CustomerRepository;
import com.barisozkan.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress= new DtoAddress();
		Optional<Customer> optional= customerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Customer customer = optional.get();
		Address address = optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		dtoCustomer.setAddress(dtoAddress);
		return dtoCustomer;
	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU customerIU) {
		DtoCustomer response = new DtoCustomer();
		
		Address address = new Address();
		BeanUtils.copyProperties(customerIU.getAddress(), address);
		
		Address dbAddress = addressRepository.save(address);
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerIU, customer);
		customer.setAddress(dbAddress);
		
		Customer dbCustomer = customerRepository.save(customer);
		
		BeanUtils.copyProperties(dbCustomer, response);
		response.setAddress(new DtoAddress(dbAddress.getId(), dbAddress.getDescription()));
		return response;
	}

	@Override
	public void deleteCustomer(Long id) {
		Optional<Customer> optional =customerRepository.findById(id);
		if (optional.isPresent()) {
			customerRepository.delete(optional.get());
		}
	}

	@Override
	public List<DtoCustomer> getAllCustomer() {
		List<DtoCustomer> dtoCustomerList= new ArrayList<>();
		List<Customer> customerList = customerRepository.findAll();
		for (Customer customer : customerList) {
			DtoCustomer dtoCustomer = new DtoCustomer();
			BeanUtils.copyProperties(customer, dtoCustomer);

			
			Address address= customer.getAddress();
			if (address!=null) {
				DtoAddress dtoAddress = new DtoAddress();
				BeanUtils.copyProperties(address, dtoAddress);
				dtoCustomer.setAddress(dtoAddress);
			}
			dtoCustomerList.add(dtoCustomer);
		}
		return dtoCustomerList;
	}

	@Override
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dto = new DtoCustomer();
		Optional<Customer> optional= customerRepository.findById(id);
		if (optional.isPresent()) {
			Customer dbCustomer = optional.get();
			dbCustomer.setName(dtoCustomerIU.getName());
			
			if (dtoCustomerIU.getAddress()!=null) {
				if (dbCustomer.getAddress()==null) {
					Address newAddress = new Address();
					BeanUtils.copyProperties(dtoCustomerIU.getAddress(), newAddress);
					dbCustomer.setAddress(addressRepository.save(newAddress));
				}else {
					Address dbAddress = dbCustomer.getAddress();
					dbAddress.setDescription(dtoCustomerIU.getAddress().getDescription());
					addressRepository.save(dbAddress);
				}
			}
			Customer updatedCustomer = customerRepository.save(dbCustomer);
	        BeanUtils.copyProperties(updatedCustomer, dto);

	        // Address'i de DTO'ya ekleyin
	        if (updatedCustomer.getAddress() != null) {
	            DtoAddress dtoAddress = new DtoAddress();
	            BeanUtils.copyProperties(updatedCustomer.getAddress(), dtoAddress);
	            dto.setAddress(dtoAddress);
	        }
	        return dto;
		}
		return null;
	}

}
