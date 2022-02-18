package com.example.springdatajpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.model.Account;
@Repository
public interface AccountRepo extends CrudRepository<Account, Integer>{

}
