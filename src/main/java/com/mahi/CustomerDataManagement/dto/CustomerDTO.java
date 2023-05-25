package com.mahi.CustomerDataManagement.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.mahi.CustomerDataManagement.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements Serializable{
	private Integer id;
	private String name;
	private String email;
	
	public CustomerDTO (Customer customer) {
		this.id=customer.getId();
		this.name=customer.getName();
		this.email=customer.getEmail();
	}

}
