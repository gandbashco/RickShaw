package com.rickshaw;

import com.rickshaw.domain.Customer;
import com.rickshaw.domain.Order;
import com.rickshaw.repository.CustomerRepository;
import com.rickshaw.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class RickShawApplication {

	private static final Logger log = LoggerFactory.getLogger(RickShawApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RickShawApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, CustomerService customerService) {
		return (args) -> {
			// save a couple of customers
            Order o = new Order();
			o.setDateCreated(new Date());
			o.setTotal((BigDecimal.valueOf(22.34)));
            Customer c = new Customer("Jack", "Bauer", "jbauer@springboot.com", "secret");
            c.addOrder(o);
            System.out.println("Customer: " + c);
            customerRepository.save(c);
		};
	}
}
