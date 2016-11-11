package com.rickshaw.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
	
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;

    private List<Order> orders = new ArrayList<>();

    public Customer() {

    }

	public Customer(String firstname, String lastname,
                    String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
