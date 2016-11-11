package com.rickshaw.dao;

import com.rickshaw.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerDaoTest.class);

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void getById_should_get_specific_customer() throws Exception {
        Customer customer = customerDao.getById(1L);
        log.debug("Customer retrieved: " + customer);
        assertNotNull(customer);
    }

    @Test (expected = DataAccessException.class)
    public void getById_negative() throws Exception {
        Customer customer = customerDao.getById(-1L);
        log.debug("Customer retrieved: " + customer);
        assertNull(customer);
    }

    @Test
    public void getAll_should_get_all_customers() throws Exception {
        List<Customer> customers = (List<Customer>) customerDao.getAll();
        assertNotNull(customers);
        assertEquals(5, customers.size());
    }

    @Test
    public void create_should_add_new_customer() throws Exception {
        Customer testCustomer = new Customer("Moe", "B",
                                            "moeb@test-email.com", "fake-password");
        assertEquals(true, customerDao.create(testCustomer));
    }
}