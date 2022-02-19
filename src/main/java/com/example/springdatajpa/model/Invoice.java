package com.example.springdatajpa.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<InvoiceDetail> getInovoiceDetails() {
		return invoiceDetails;
	}

	public void setInovoiceDetails(Set<InvoiceDetail> inovoiceDetails) {
		this.invoiceDetails = inovoiceDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	private String name;
	private String payment;
	private String status;
	private Date created;

	public Invoice(Account account, String name, String payment, String status, Date created,
			Set<InvoiceDetail> invoiceDetails) {
		super();

		this.account = account;
		this.name = name;
		this.payment = payment;
		this.status = status;
		this.created = created;
		this.invoiceDetails = invoiceDetails;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "invoice",  cascade = CascadeType.ALL)

	private Set<InvoiceDetail> invoiceDetails;

}
