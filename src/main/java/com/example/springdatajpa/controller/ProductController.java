package com.example.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springdatajpa.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping
	public String index(ModelMap map) {
		map.put("products",productService.findAll());
		return "index";
	}
}
