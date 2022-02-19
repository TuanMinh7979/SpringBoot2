package com.example.springdatajpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {
	@Query("select count(id) from Account where username =: username")
	long countUserName(@Param("username") String username);
}
