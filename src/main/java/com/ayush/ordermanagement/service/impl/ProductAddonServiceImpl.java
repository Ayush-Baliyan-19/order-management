package com.ayush.ordermanagement.service.impl;

import com.ayush.ordermanagement.domain.ProductAddon.ProductAddon;
import com.ayush.ordermanagement.service.ProductAddonService;
import org.springframework.stereotype.Service;

@Service
public class ProductAddonServiceImpl implements ProductAddonService {

    @Override
    public ProductAddon createProductAddon() {
        return new ProductAddon();

    }

    @Override
    public ProductAddon getProductAddon() {
        return new ProductAddon();
    }
}
