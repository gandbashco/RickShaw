package com.rickshaw.service;

import java.math.BigDecimal;
import java.util.Hashtable;

import com.rickshaw.domain.Order;
import org.springframework.stereotype.Service;

import com.rickshaw.domain.Product;

@Service
public class OrderService {

    Hashtable<String, Order> orders = new Hashtable<String, Order>();

    Order order = new Order();
    order.setId(1);
    order.setDateCreated(new Date());
    order.setTotal(new BigDecimal(100.00));
}
