package com.example.springdatajpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

}
