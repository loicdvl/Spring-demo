package com.loicdev.springdemo.service;

import java.util.List;

import com.loicdev.springdemo.api.model.CustomerDTO;
import com.loicdev.springdemo.domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);
    
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);

    List<Customer> findAll(Specification<Customer> spec);
}