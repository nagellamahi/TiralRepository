package com.mahi.CustomerDataManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahi.CustomerDataManagement.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>{

}
