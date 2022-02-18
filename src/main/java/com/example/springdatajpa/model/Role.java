package com.example.springdatajpa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNane() {
		return nane;
	}

	public void setNane(String nane) {
		this.nane = nane;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nane;
	
	
	//MANY TO MANY
	@ManyToMany(mappedBy="roles")
	private Set<Account> accounts;

	public Role(int id, String nane) {
		super();
		this.id = id;
		this.nane = nane;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
