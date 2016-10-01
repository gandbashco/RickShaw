package com.rickshaw.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private long id;
    private String name;
    private String number;
    private BigDecimal price;
}
