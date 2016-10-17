package com.rickshaw;

import com.rickshaw.dao.CustomerDao;

import com.rickshaw.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class RickShawApplication {

	private static final Logger log = LoggerFactory.getLogger(RickShawApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RickShawApplication.class, args);

		CustomerDao customerDao = context.getBean(CustomerDao.class);

		List<Customer> customers = customerDao.getCustomerByName();

		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
