package com.rickshaw.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;

import com.rickshaw.domain.Order;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private Hashtable<String, Order> orders = new Hashtable<String, Order>();

    public Hashtable<String, Order> getOrders() {
        return orders;
    }

    public OrderService() {
        Order order = new Order();
        order.setId(1);
        order.setDateCreated(new Date());
        order.setTotal(new BigDecimal(100.00));
        orders.put("1", order);
    }
}
