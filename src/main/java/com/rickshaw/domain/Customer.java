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

}
