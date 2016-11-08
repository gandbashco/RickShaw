package com.rickshaw.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    private long id;
    private Date dateCreated;
    private BigDecimal total;
}
