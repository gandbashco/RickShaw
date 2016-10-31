package com.rickshaw.service;

import com.rickshaw.dao.CustomerDao;
import com.rickshaw.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
    private CustomerDao customerDao;

    public Collection<Customer> getAll() {
        return customerDao.getAll();
    }

    public Customer getCustomerById(long id) {
        return customerDao.getById(id);
    }
}
