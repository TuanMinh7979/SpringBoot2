package com.example.springdatajpa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	//*-many thi co mapped by tuc day la bang cha thi co bien tham chieu luu ben bang con 
	@OneToMany(mappedBy="category")
	private Set<Product> products;
	

}
