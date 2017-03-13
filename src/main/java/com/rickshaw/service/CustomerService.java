package com.rickshaw.service;

import com.rickshaw.domain.Customer;
import com.rickshaw.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
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

    public void updateCustomer(Long id, Customer customer) throws Exception {
        customerRepository.save(customer);
    }

}
