package com.example.springdatajpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatajpa.model.Invoice;
import com.example.springdatajpa.repo.InvoiceRepo;
import com.example.springdatajpa.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepo invoiceRepo;

	@Override
	public Invoice findById(int id) {
		// TODO Auto-generated method stub
		return invoiceRepo.findById(id).get();
	}

	@Override
	public double sumOfAOrder(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepo.sumOfAOrder(invoice);
	}

	@Override
	public double sumPofOrdGiMandY(int month, int year) {

		return invoiceRepo.sumPofOrdGiMandY(month, year);
	}

}
