package com.rickshaw.dao;

import com.rickshaw.domain.Customer;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getCustomerByFirstName(String firstName) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstname", firstName);

        return jdbcTemplate.query("select * from customer where firstname = :firstname", params, new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createCustomerFromResultSet(rs);
            }
        });
    }

    public Customer getCustomerById(Long id) {

        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbcTemplate.queryForObject("select * from customer where id = :id", params, new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createCustomerFromResultSet(rs);
            }
        });
    }

    // Follow the offers model to see how to get all customers
    // Delete a customer
    // Create
    // Update

    private Customer createCustomerFromResultSet(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));
        customer.setEmail(rs.getString("email"));
        customer.setPassword(rs.getString("password"));
        return customer;
    }

}
