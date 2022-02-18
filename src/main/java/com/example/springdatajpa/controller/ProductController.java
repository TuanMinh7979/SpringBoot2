package com.example.springdatajpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdatajpa.repo.CategoryRepo;
import com.example.springdatajpa.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryRepo categoryRepo;

	@GetMapping("")
	public String index(ModelMap map) {
		map.put("products", productService.findAll());
		map.put("productNonActive", productService.findByStatus(false));
		map.put("productPrices", productService.findByPrices(125, 130));
		// khong phan biet chu khoa chu chuong
		// cho nen la As as AS hay aS deu lay het ca
		map.put("productLike", productService.likeName("as"));
		map.put("productByYear", productService.findByYear(2021));
		map.put("productByYearAndMonth", productService.findByYearAndMonth(2022, 1));
//		map.put("byDate", productService.findByDate(new Date(), null));
		return "index";
	}

	@GetMapping("/bydate")
	public String bydate(ModelMap map) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date start = df.parse("1/1/2021");
			Date end = df.parse("15/1/2022");
			map.put("productbydate", productService.findByDate(start, end));
			return "index";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			map.put("errs", "Co loi voi date");
			System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
			e.printStackTrace();
		}
//		return "redirect:/";
		return "index";

	}

//	@GetMapping("/form")
//	public String showForm() {
//		return "form";
//	}

//	@PostMapping("/form")
//	public String hdlForm(@RequestParam("date") String date) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Product p = new Product();
//		p.setName("new product");
//		p.setPrice(123);
//		p.setQuanlity(10);
//		p.setStatus(false);
//		p.setCategory(categoryRepo.getById(1));
//		
//		try {
//			Date d= df.parse(date);
//			p.setCreated(d);
//			productService.save(p);
//			return "redirect:/";
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return "form";
//	}
}
