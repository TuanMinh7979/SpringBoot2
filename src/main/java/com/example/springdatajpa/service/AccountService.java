package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Account;

public interface AccountService {
	Iterable<Account> findAll();
}
