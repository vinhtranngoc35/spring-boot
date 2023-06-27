package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void add(Product product){
        products.add(product);
    }
}
