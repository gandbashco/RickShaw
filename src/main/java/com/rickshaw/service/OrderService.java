package com.rickshaw.service;

import com.rickshaw.domain.Customer;
import com.rickshaw.domain.Order;
import com.rickshaw.repository.CustomerRepository;
import com.rickshaw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    public Set<Order> getOrdersByCustomer(Long customerId) {
        Set<Order> orders = new HashSet<>();
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findOne(customerId));
        if (customer.isPresent()) {
            orders =  customer.get().getOrders();
        }
        return orders;
    }
}
