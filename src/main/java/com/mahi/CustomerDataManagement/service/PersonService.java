package com.mahi.CustomerDataManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.CustomerDataManagement.entity.BankAccount;
import com.mahi.CustomerDataManagement.entity.Person;
import com.mahi.CustomerDataManagement.repository.PersonDAO;

@Service
public class PersonService {
	@Autowired
	private PersonDAO dao;
	
public Person savePerson(Person person) {
	return dao. save(person);
}
public List<Person> getAllPersonDetails(){
	 return  dao.getAllPersonDetails();
	
}
 public  List<BankAccount> getAllBankAccountData() {
	  return dao.getAllBankAccountData();
 }
 
public List<Person> getByPersonName(String name) {
return dao.getByPersonName(name);
}

public BankAccount getByBankId(int id) {

return dao.getByBankId(id);
}

public Person getByPersonId(int id) {

return dao.getByPersonId(id);
}

public Person deleteByPersonId(int id) {
return dao.deleteByPersonId(id);
}

public BankAccount deleteByBankId(int id) {

return dao.deleteByBankId( id);
}

/*public BankAccount getByBankAccountNum(int accountNum) {
// TODO Auto-generated method stub
return dao.getByBankAccountNum(accountNum);
}*/

}


