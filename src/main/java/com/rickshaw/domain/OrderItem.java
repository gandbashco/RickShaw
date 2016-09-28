package com.rickshaw.domain;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItem {

    private long id;
    private int quantity;
    private BigDecimal total;
}
