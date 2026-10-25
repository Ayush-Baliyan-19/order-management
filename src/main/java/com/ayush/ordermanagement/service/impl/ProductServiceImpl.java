package com.ayush.ordermanagement.service.impl;

import com.ayush.ordermanagement.domain.Product.Product;
import com.ayush.ordermanagement.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product createProduct() {
        return new Product();
    }

    @Override
    public Product getProduct() {
        return new Product();
    }
}
