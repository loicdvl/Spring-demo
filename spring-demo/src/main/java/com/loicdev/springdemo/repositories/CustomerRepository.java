package com.loicdev.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loicdev.springdemo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
