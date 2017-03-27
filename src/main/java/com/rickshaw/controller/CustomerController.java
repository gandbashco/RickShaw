package com.rickshaw.controller;

import com.rickshaw.domain.Customer;
import com.rickshaw.domain.Order;
import com.rickshaw.service.CustomerService;
import com.rickshaw.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public Set<Order> getOrdersByCustomer(@PathVariable("id") Long id) {
        return orderService.getOrdersByCustomer(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
        log.debug("Converting JSON values to Customer object: " + customer.toString());
        customerService.createCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateCustomer( @PathVariable("id") String id, @RequestBody Customer customer) throws Exception {
        customerService.updateCustomer(Long.parseLong(id), customer);
    }

}
