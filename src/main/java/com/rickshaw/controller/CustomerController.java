package com.rickshaw.controller;

import com.rickshaw.domain.Customer;
import com.rickshaw.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
        log.debug("Converting JSON values to Customer object: " + customer.toString());
        customerService.createCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {
        log.debug("Converting JSON values to Customer object: " + customer.toString());
        customerService.updateCustomer(customer);
        return customer;
    }

}
