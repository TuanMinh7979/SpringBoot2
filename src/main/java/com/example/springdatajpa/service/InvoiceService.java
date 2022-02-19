package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Invoice;

public interface InvoiceService {
   Invoice findById(int id);
   
   double sumOfAOrder(Invoice invoice);
   
   double sumPofOrdGiMandY(int month, int year);
}
