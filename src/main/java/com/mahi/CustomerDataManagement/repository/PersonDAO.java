package com.mahi.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahi.CustomerDataManagement.entity.BankAccount;
import com.mahi.CustomerDataManagement.entity.Person;

@Repository
public class PersonDAO {
	
@Autowired
	
	private PersonRepository repository;
	@Autowired
	private BankRepository bankRepository;
	
public Person save(Person person)
{
	return repository.save(person);
}
public List<Person> getAllPersonDetails()
{
	return repository.findAll();
}
public List<BankAccount> getAllBankAccountData() {
	return bankRepository.findAll();
	
}
public List<Person>  getByPersonName(String name) {
	return repository.findByName(name);
}
public BankAccount getByBankId(int id) {
	
	return bankRepository.findById(id).orElse(null);
}
/*public BankAccount getByBankAccountNum(int accountNum) {
	
	return bankRepository.findById(accountNum).orElse(null);
}*/
public Person getByPersonId(int id) {
	
	return repository.findById(id).orElse(null);
}
public Person deleteByPersonId(int id) {
	
	Person person=deleteByPersonId(id);
	if(person.getId()!=404) {
		repository.deleteById(id);
	}
	return person;
}
public BankAccount deleteByBankId(int id) {
	BankAccount account=deleteByBankId(id);
	if(account.getPId()!=404) {
		repository.deleteById(id);
	}
	return account;}
}