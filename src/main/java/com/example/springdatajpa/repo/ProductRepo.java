package com.example.springdatajpa.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

//	@Query("from Product where status=:status")
//	List<Product> findByStatus(@Param("status") boolean status);
//Ta co the viet gon hon nhu sau:
	List<Product> findByStatus(boolean status);

//*
	@Query("from Product where price >= :min and price <= :max")
	List<Product> findByPrices(@Param("min") int min, @Param("max") int max);

	@Query("from Product where name like %:kw%")
	List<Product> likeName(@Param("kw") String kw);

	// nay cho nap chong phuong thuc cho de nho

	@Query("from Product where year(created) = :year")
	List<Product> findByYear(@Param("year") int year);

	@Query("from Product where year(created) = :year and month(created) = :month")
	List<Product> findByYearAndMonth(@Param("year") int year, @Param("month") int month);

	@Query("from Product where year(created) = :year and month(created) = :month and day(created)= :day")
	List<Product> findByYMD(@Param("year") int year, @Param("month") int month, @Param("day") int day);

	@Query("from Product where created >= :start and created <= :end")
	public List<Product> findByDate(@Param("start") Date start, @Param("end") Date end);

}
