package com.example.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdatajpa.model.Account;
import com.example.springdatajpa.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@GetMapping("")
	public String indexAccount(ModelMap map) {
		//khong the ep kieu sang List
		Iterable<Account> accounts= accountService.findAll(); 
		map.put("accounts", accounts);
		return "account/index";
	}

}
