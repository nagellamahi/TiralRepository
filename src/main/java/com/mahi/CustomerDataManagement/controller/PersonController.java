package com.mahi.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.CustomerDataManagement.entity.BankAccount;
import com.mahi.CustomerDataManagement.entity.Person;
import com.mahi.CustomerDataManagement.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;
	
	@PostMapping("/person")
	public @ResponseBody Person savePerson(@RequestBody Person person)
	{
		return service.savePerson(person);
	}
@GetMapping("/person")
	public @ResponseBody List<Person> getAllPersonDetails() {
		return service.getAllPersonDetails();
	}
@GetMapping("/bank")
		 public @ResponseBody List<BankAccount> getAllBankAccountData() {
	
	return service.getAllBankAccountData();
}
@GetMapping("/person/{name}")
public List<Person> getByPersonName(@PathVariable("name") String name) {
	return service.getByPersonName(name);
}
@GetMapping("/bank/{id}")
public BankAccount getByBankId(@PathVariable("id") int id){
	return service.getByBankId(id);
}

@GetMapping("/person/{id}")
public Person getByPersonId(@PathVariable("id") int id) {
return service.getByPersonId(id);

}
@DeleteMapping("/deleteByPersonId")
public @ResponseBody Person  deleteByPersonId(@RequestParam("id") int id){
	return service.deleteByPersonId(id);
}
@DeleteMapping("/deleteByBankId")
public @ResponseBody BankAccount  deleteByBankId(@RequestParam("id") int id){
	return service.deleteByBankId(id);
}
}
/*@GetMapping("/bank/{accountNumber}")
public BankAccount getByBankAccountNum(@PathVariable("accountNum") int accountNum)
{
	return service.getByBankAccountNum(accountNum);
}*/