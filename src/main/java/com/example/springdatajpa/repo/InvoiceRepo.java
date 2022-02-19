package com.example.springdatajpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Invoice;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice, Integer> {
	@Query("select sum( unit_price * quanlity ) from InvoiceDetail where invoice= :invoice")
	double sumOfAOrder(@Param("invoice") Invoice invoice);

	// tinh tong tien tong cac hoa don cua 1 thang bat ky trong nam cho trc
	@Query("select sum(unit_price * quanlity ) from InvoiceDetail where year(invoice.created)= :yeari and month(invoice.created) = :monthi")
	double sumPofOrdGiMandY(@Param("monthi") int month, @Param("yeari") int year);

	// tinh tong tien cua hoa don cua 1 khach hang mua trong 1 nam
	@Query("select sum(unit_price * quanlity ) from InvoiceDetail where invoice.account.fullName= :fullName")
	double sumByAccinY(@Param("fullName") String fullName);

}
