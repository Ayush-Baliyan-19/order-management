package com.ayush.ordermanagement.controller.internal;

import com.ayush.ordermanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/internal/product")
@RequiredArgsConstructor
public class ProductController {

    ProductService productService;
    @PostMapping
    public void createProduct()
    {
        productService.createProduct();
    }

    @GetMapping(":productId")
    public void getProduct(@RequestParam String productId){
        productService.getProduct();
    }
}
