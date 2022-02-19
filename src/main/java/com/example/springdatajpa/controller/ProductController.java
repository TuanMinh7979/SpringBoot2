package com.example.springdatajpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springdatajpa.model.Invoice;
import com.example.springdatajpa.repo.CategoryRepo;
import com.example.springdatajpa.service.InvoiceService;
import com.example.springdatajpa.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryRepo categoryRepo;

	@GetMapping(value = { "", "/{limit}" })
	public String index(ModelMap map, @PathVariable(value = "limit", required = false) int n) {
		if (n != 0) {
			map.put("productLimit", productService.limit(n));
			return "index";
		}
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

			e.printStackTrace();
		}
//		return "redirect:/";
		return "index";

	}

	@GetMapping("/sort")
	public String sort(ModelMap map) {
		map.put("productBySortASC", productService.sortPriceASC());
		return "index";
	}

	@GetMapping("/dto")
	public String getDto(ModelMap map) {
		map.put("productDto", productService.findAll2());
		return "index2";
	}

	// BUOI 10
	@GetMapping("/sum")
	public String sum(ModelMap map,
			@RequestParam(value = "status", required = false, defaultValue = "true") boolean sta) {

//		map.put("sumPQwithStatus", productService.sumQuanlity1(sta));

		map.put("sumproductquanlity", productService.sumQuanlity());
		map.put("sumPPrice", productService.sum2(sta));
		map.put("count", productService.count());
		map.put("countWstatus", productService.count2(sta));
		map.put("maxPrice", productService.max());
		Invoice testins = invoiceService.findById(1);
		map.put("sumofAOrder", invoiceService.sumOfAOrder(testins));
		map.put("sumorderpricebymad", invoiceService.sumPofOrdGiMandY(2, 2022));
		return "indexx";
	}

}
