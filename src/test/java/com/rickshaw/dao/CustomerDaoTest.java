package com.rickshaw.dao;

import com.rickshaw.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerDaoTest.class);

    @Autowired
    private CustomerDao customerDao;

//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }

    @Test
    public void getByFirstName() throws Exception {

    }

    @Test
    public void getById() throws Exception {
        Customer customer = customerDao.getById(1L);
        log.debug("Customer retrieved: " + customer);
        assertNotNull(customer);
    }

    @Test
    public void getByIdNegative() throws Exception {
        Customer customer = customerDao.getById(-1L);
        log.debug("Customer retrieved: " + customer);
        assertNull(customer);
    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}