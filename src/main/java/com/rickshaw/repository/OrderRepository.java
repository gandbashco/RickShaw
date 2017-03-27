package com.rickshaw.repository;

import com.rickshaw.domain.Customer;
import com.rickshaw.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class OrderRepository {

    @Autowired
    private CustomerRepository customerRepository;

    public Set<Order> findByCustomer(Long customerId) {
        Set<Order> orders = new HashSet<>();
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findOne(customerId));
        if (customer.isPresent()) {
            orders =  customer.get().getOrders();
        }
        return orders;
    }
}
