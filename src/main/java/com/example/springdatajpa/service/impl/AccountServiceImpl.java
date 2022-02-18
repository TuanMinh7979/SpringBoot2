package com.example.springdatajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.model.Account;
import com.example.springdatajpa.repo.AccountRepo;
import com.example.springdatajpa.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}

}
