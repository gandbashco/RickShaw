package com.rickshaw.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	private String password;

    /*
    todo: Are these constructors below really necessary considering the fact we may not be using Lombok properly?
     */
	public Customer() {

	}


    public Customer(String firstname, String lastname,
                    String email, String password) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }

	// private List<Order> orders = new ArrayList<>();
}
