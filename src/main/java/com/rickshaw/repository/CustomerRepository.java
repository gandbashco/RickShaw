package com.rickshaw.repository;

import com.rickshaw.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    // todo: return only single customer or do partial e-mail match.
    List<Customer> findByEmail(String lastName);

}