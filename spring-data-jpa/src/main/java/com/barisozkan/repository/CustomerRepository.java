package com.barisozkan.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barisozkan.entites.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	


}
