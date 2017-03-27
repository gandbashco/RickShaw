package com.rickshaw.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
/*
The next two annotations avoid a stack overflow error which is caused by Lombok's @Data annotation. This is caused
by toString and hashCode methods from both classes calling each other recursively.
*/
@ToString(exclude = "customer")
@EqualsAndHashCode(exclude = "customer")
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private Date dateCreated;

    @NotNull
    private BigDecimal total;

    /*
    This annotation is helpful because without it, fetching a customer, which results in fetching their
    orders, will result in fetching the customer back again and hence infinite recursion due to the back reference
    to the owning customer in this class.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
