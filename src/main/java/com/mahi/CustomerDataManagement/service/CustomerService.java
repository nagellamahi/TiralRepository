package com.mahi.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mahi.CustomerDataManagement.dto.CustomerDTO;
import com.mahi.CustomerDataManagement.dto.ReponseStructure;
import com.mahi.CustomerDataManagement.entity.Customer;
import com.mahi.CustomerDataManagement.repository.CustomerDAO;
import com.mahi.CustomerDataManagement.repository.CustomerRepository;

@Service
public class CustomerService {
      @Autowired
      private CustomerDAO dao;
      
      
      public ReponseStructure<Customer> saveCustomer(CustomerDTO  dto) {
    	 Customer cus= new Customer(dto);   
        Customer customer= dao.saveCustomer(cus);
        ReponseStructure<Customer> rs= new ReponseStructure<>();
        rs.setData(customer);
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Customer data saved successfully");
        rs.setTimeStamp(LocalDateTime.now());
        return rs;
      }
      
      public ReponseStructure<Customer> updateCustomer(Customer customer) {
    	Customer cus=dao.saveCustomer(customer);
    	ReponseStructure<Customer> rs= new ReponseStructure<>();
    	rs.setStatusCode(HttpStatus.ACCEPTED.value());
    	rs.setTimeStamp(LocalDateTime.now());
    	rs.setMessage(HttpStatus.ACCEPTED.name());
    	return  rs;
      }
      public ReponseStructure<List<Customer>> getAllCustomerData() {
    	  List<Customer> list = dao.getAllCustomerData();
    	  ReponseStructure<List<Customer>> rs = new ReponseStructure<>();
    	  if(list.size()!=0) {
    		  rs.setStatusCode(HttpStatus.FOUND.value());
    		  rs.setData(list);
    		  rs.setTimeStamp(LocalDateTime.now());
    		  rs.setMessage("Customers entity found in database");
    	  }else {
    		  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
    		  rs.setData(null);
    		  rs.setTimeStamp(LocalDateTime.now());
    		  rs.setMessage("No Customers entity found in database");
    		  
    	  }
    	  
    	  return rs;
    		  
    		  
    		  
    		  
    	  
      }
      public Customer getCustomerDataBYId(int id) {
    	  return dao.getCustomerDataById(id);
      }
      public Customer deleteCustomerDataById(int id) {
    	 return dao.deleteCustomerDataById(id);
      }
      public List<Customer> getCustomerByName(String name) {
 		 return dao.getCustomerByName(name);
 	 }
      public List<Customer> validateCustomer(String name,String email){
    	  return dao.validateCustomer(name, email);
      }
}
