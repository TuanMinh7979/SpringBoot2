package com.example.springdatajpa.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		// khong the ep kieu sang List
		Iterable<Account> accounts = accountService.findAll();
		map.put("accounts", accounts);
		return "account/index";
	}

	@GetMapping("/add")
	public String showAddForm(ModelMap map) {
		map.put("account", new Account());
		return "account/add";
	}

	@PostMapping("/add")
	public String hdleAddnew(@RequestBody Account acc) {
		acc.setPassword(BCrypt.hashpw(acc.getPassword(), BCrypt.gensalt()));
		accountService.save(acc);
		return "redirect:/account";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap map) {

		map.put("account", accountService.findById(id));
		return "account/edit";

	}

	@DeleteMapping("/del/{id}")
	public void del(@PathVariable("id") int id) {
		System.out.println("VAO DAY XOA ----------------------"+id);
		accountService.DeleteById(id);
	
	}

}
