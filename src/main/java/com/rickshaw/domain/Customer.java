package com.rickshaw.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * A class representing a customer resource.
 *
 * @author  Mudassar "Moe" Bashir
 * @see com.rickshaw.domain.Order
 */
@Data
@NoArgsConstructor
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

    /**
     * The orders owned by this customer.
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    public Customer(String firstName, String lastName,
                    String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
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
