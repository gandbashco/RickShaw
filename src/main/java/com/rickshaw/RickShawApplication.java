package com.rickshaw;

import com.rickshaw.domain.Customer;
import com.rickshaw.repository.CustomerRepository;
import com.rickshaw.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;

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
			customerRepository.save(new Customer("Jack", "Bauer", "jbauer@springboot.com", "secret"));
			customerRepository.save(new Customer("John", "Doe", "jdoe@springboot.com", "secret2"));
			customerRepository.save(new Customer("Sultan", "Rahi", "srahi@punjabiTV.com", "raaz"));
			customerRepository.save(new Customer("Curly", "Stooge", "cstooge@3stooges.com", "soitenly"));
            Iterable<Customer> customers = customerService.getAll();
            log.info(customers.toString());
		};
	}
}
