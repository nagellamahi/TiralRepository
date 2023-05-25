package com.mahi.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.CustomerDataManagement.dto.CustomerDTO;
import com.mahi.CustomerDataManagement.dto.ReponseStructure;
import com.mahi.CustomerDataManagement.entity.Customer;
import com.mahi.CustomerDataManagement.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	@PostMapping("/customer")
	public @ResponseBody ReponseStructure<Customer> saveCustomer(@RequestBody CustomerDTO dto) {
		return service.saveCustomer(dto);
	}
	@PutMapping("/customer")
	public @ResponseBody ReponseStructure<Customer> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@GetMapping("/customer")
	public @ResponseBody ReponseStructure<List<Customer>> getAllcustomerData() { 
		return service.getAllCustomerData();
	}
	@GetMapping("/customer/{id}")
	public Customer getCustomerDataById(@PathVariable("id")int id) {
		return service.getCustomerDataBYId(id);
	}
	@DeleteMapping("/customer")
	public @ResponseBody  Customer deleteCustomerDataById(@RequestParam("id")int id) {
	return service.deleteCustomerDataById(id);
}
	@GetMapping("/customerbyname/{name}")
	public @ResponseBody List<Customer> getCustomerByName (@PathVariable("name")String name) {
		 return service.getCustomerByName(name);
	 }
	@PostMapping("/validatecustomer")
	public List<Customer> validatedateCustomer(@RequestParam(" name")String name, @RequestParam("email")String email){
		return service.validateCustomer(name, email);
	}
}
