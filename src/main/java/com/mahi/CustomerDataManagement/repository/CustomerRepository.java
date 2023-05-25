package com.mahi.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mahi.CustomerDataManagement.entity.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByName(String name);
	
	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.email=:email")
	List<Customer> validateCustomer(@Param("name")String name,@Param("email")String email);

}
