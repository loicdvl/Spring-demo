package com.loicdev.springdemo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.loicdev.springdemo.domain.Customer;
import com.loicdev.springdemo.specification.CustomerSpecificationsBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.loicdev.springdemo.api.model.CustomerDTO;
import com.loicdev.springdemo.api.model.CustomerListDTO;
import com.loicdev.springdemo.service.CustomerService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Validated
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomers(){
        return new CustomerListDTO(customerService.getAllCustomers());
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<Customer> search(@RequestParam(value = "search") String search) {
        CustomerSpecificationsBuilder builder = new CustomerSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Customer> spec = builder.build();
        return customerService.findAll(spec);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable @Min(1) Long id){
        return customerService.getCustomerById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable @Min(1) Long id, @Valid @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(id, customerDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable @Min(1) Long id, @Valid @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable @Min(1) Long id){
        customerService.deleteCustomerById(id);
    }
}
