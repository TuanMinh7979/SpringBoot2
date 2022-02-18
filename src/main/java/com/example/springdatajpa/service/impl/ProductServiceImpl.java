package com.example.springdatajpa.service.impl;

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

}
