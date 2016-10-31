package com.rickshaw.controller;

import com.rickshaw.domain.Customer;
import com.rickshaw.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

	/* Controller should be able to respond to requests for:
	1. List all customers. DONE.
	2. List one customer. DONE.
	3. Create a customer.
	4. Delete a customer.
	5. Update a customer.
	 */

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") long id) {
        return customerService.getCustomerById(id);
    }
}
