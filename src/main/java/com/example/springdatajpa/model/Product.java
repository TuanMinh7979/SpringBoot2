package com.example.springdatajpa.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private int price;
	private int quanlity;
	private boolean status;
	private Date created;
	private String description;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	//*-One tuc day la bang con thi co Joincolumn goi den bang cha
	private Category category;

	public Product(String name, int price, int quanlity, boolean status, Date created, String description,
			Category category) {
		super();

		this.name = name;
		this.price = price;
		this.quanlity = quanlity;
		this.status = status;
		this.created = created;
		this.description = description;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
