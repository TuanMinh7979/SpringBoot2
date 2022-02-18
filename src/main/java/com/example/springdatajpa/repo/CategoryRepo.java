package com.example.springdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
