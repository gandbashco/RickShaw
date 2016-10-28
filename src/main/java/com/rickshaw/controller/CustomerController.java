package com.rickshaw.controller;

import com.rickshaw.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;

	/* Controller should be able to respond to requests for:
	1. List all customers.
	2. List one customer.
	3. Create a customer.
	4. Delete a customer.
	5. Update a customer.
	 */
	

}
