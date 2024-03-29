package com.loicdev.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loicdev.springdemo.domain.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}
