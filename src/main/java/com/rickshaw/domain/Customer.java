package com.rickshaw.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

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

    public void addOrder(Order order) {
        order.setCustomer(this);
        getOrders().add(order);
    }

    public void removeOrder(Order order) {
        getOrders().remove(order);
    }

}
