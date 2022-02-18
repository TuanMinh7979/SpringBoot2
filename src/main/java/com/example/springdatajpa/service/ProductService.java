package com.example.springdatajpa.service;

import java.util.Date;
import java.util.List;

import com.example.springdatajpa.model.Product;

public interface ProductService {
	Iterable<Product> findAll();
	Product find(int id);
	Product save(Product product);
	void delete(int id);
	
	//
	List<Product> findByStatus( boolean status);
	
	List<Product> findByPrices(int min, int max);
	
	List<Product> likeName(String kw);
	
	List<Product> findByYear(int year);
	
	List<Product> findByYearAndMonth(int year, int month);
	
	List<Product> findByDate(Date start, Date end);
	
}
