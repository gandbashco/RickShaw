package com.rickshaw.service;

import com.rickshaw.repository.CustomerRepository;
import com.rickshaw.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Slf4j

@Service
public class CustomerService {

    //private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAll() {
        log.error("fake error");
        return customerRepository.findAll();

    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }

}
