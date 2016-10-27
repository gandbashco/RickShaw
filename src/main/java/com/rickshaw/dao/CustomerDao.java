package com.rickshaw.dao;

import com.rickshaw.domain.Customer;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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

    public List<Customer> getByFirstName(String firstName) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstname", firstName);

        return jdbcTemplate.query("select * from customer where firstname = :firstname", params, new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createCustomerFromResultSet(rs);
            }
        });
    }

    public Customer getById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbcTemplate.queryForObject("select * from customer where id = :id", params, new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createCustomerFromResultSet(rs);
            }
        });
    }

    public List<Customer> getAll() {
        return jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createCustomerFromResultSet(rs);
            }
        });
    }

    public void delete(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        jdbcTemplate.update("delete from customer where id = :id", params);
    }

    // Create
    public boolean create(Customer customer) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(customer);
        return jdbcTemplate.update("insert into customer (firstname, lastname, email, password) " +
                                    "values (:firstname, :lastname, :email, :password)", params) == 1;
        // How do we handle the orders belonging to this customer.
    }

    // Update
    public boolean update(Customer customer) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(customer);
        return jdbcTemplate.update("update customer set firstname=:firstname, " +
                                                        "lastname=:lastname, " +
                                                        "email=:email, " +
                                                        "password=:password" +
                                                        " where id=:id", params) == 1;
        // But how do we update the customer's orders?
    }


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
