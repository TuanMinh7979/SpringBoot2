package com.example.springdatajpa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.model.Product;
import com.example.springdatajpa.repo.ProductRepo;
import com.example.springdatajpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepo productRepo;

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product find(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public void delete(int id) {

		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.findByStatus(status);
	}

	@Override
	public List<Product> findByPrices(int min, int max) {
		// TODO Auto-generated method stub
		return productRepo.findByPrices(min, max);
	}

	@Override
	public List<Product> likeName(String kw) {
		// TODO Auto-generated method stub
		return productRepo.likeName(kw);
	}

	@Override
	public List<Product> findByYear(int year) {
		// TODO Auto-generated method stub
		return productRepo.findByYear(year);
	}

	@Override
	public List<Product> findByYearAndMonth(int year, int month) {
		// TODO Auto-generated method stub
		return productRepo.findByYearAndMonth(year, month);
	}
	
	@Override
	public List<Product> findByDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return productRepo.findByDate(start, end);
	}


}
