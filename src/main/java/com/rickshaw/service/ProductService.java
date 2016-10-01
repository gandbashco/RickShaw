package com.rickshaw.service;

import java.math.BigDecimal;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.rickshaw.domain.Product;

@Service
public class ProductService {

    Hashtable<String, Product> products = new Hashtable<String, Product>();

    public ProductService() {

        Product product = new Product();
        product.setId(1);
        product.setName("Starter Handle");
        product.setNumber("INPK1947");
        product.setPrice(new BigDecimal(89.99));
        products.put("1", product);

        product = new Product();
        product.setId(2);
        product.setName("Tire");
        product.setNumber("INPK1948");
        product.setPrice(new BigDecimal(54.67));
        products.put("2", product);
    }
}
