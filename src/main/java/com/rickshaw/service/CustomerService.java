package com.rickshaw.service;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickshaw.domain.Customer;

import javax.annotation.PostConstruct;

@Service
public class CustomerService {

	Hashtable<String, Customer> customers = new Hashtable<String, Customer>();

	@Autowired
	OrderService orderService;

	public CustomerService() {
		Customer cust = new Customer();
		cust.setId(1);
		cust.setFirstname("Tom");
		cust.setLastname("Jones");
		customers.put("1", cust);

		cust = new Customer();
		cust.setId(2);
		cust.setFirstname("Dick");
		cust.setLastname("Smith");
		customers.put("2", cust);

		cust = new Customer();
		cust.setId(3);
		cust.setFirstname("Harry");
		cust.setLastname("Arnold");
		customers.put("3", cust);
	}

	@PostConstruct
	private void addOrderToCustomer() {
		customers.get("3").getOrders().add(orderService.getOrders().get("1"));
	}

	public Customer getCustomer(String id) {
		if (customers.containsKey(id)) {
			return customers.get(id);
		}
		else {
			return null;
		}
	}

	public Hashtable<String, Customer> getAll() {
		return customers;
	}
}
