package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Product;

public interface ProductService {
	Iterable<Product> findAll();
}
