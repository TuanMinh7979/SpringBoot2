package com.example.springdatajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.service.ProductService;

@Controller
//AUTO CAC METHOD SE LA RESPONSE BODY NEU SU DUNG RESTCONTROLLER
public class demoController {
	@Autowired
	private ProductService productService;

	@GetMapping("/demo")
	public String demo() {

		return "demo";
	}

	@GetMapping("/demo/demo1")
	@ResponseBody
	public String demo1() {

		return "demo1";
	}

	@PostMapping("/demo/demo2")
	@ResponseBody
	public String demo2() {

		return "demo2";
	}

	@GetMapping("/demo/demo3")
	@ResponseBody
	public String demo3(@RequestParam(value = "fullName") String fullName) {

		return "hello3" + fullName;
	}

	@PostMapping("/demo/demo3P")
	@ResponseBody
	public String demo3P(@RequestParam(value = "fullName") String fullName) {

		return "Hello3P" + fullName;
	}

	@GetMapping("/demo/demo5")
	@ResponseBody
	public Product demo5() {
		Product p = productService.find(2);
//		System.out.println(p.getName());
		return p;

	}

	@GetMapping("/demo/demo6")
	@ResponseBody
	public List<Product> demo6() {

		List<Product> result = new ArrayList<>();
		productService.findAll().forEach(result::add);
		return result;

	}
}
