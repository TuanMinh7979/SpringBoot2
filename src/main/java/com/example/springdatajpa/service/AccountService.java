package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Account;

public interface AccountService {
	Iterable<Account> findAll();
	long countUserName(String username);
	Account save(Account acc);
	
	Account findById(int id);
    void DeleteById(int id);
}
