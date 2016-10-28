package com.rickshaw.service;

import com.rickshaw.dao.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	/* Service should delegate requests for requests for:
    1. List all customers.
	2. List one customer.
	3. Create a customer.
	4. Delete a customer.
	5. Update a customer.
	 */

	@Autowired
    private CustomerDao customerDao;
}
