package com.rickshaw.service;

import com.rickshaw.domain.Order;
import com.rickshaw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Set<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomer(customerId);
    }
}
