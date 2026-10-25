package com.ayush.ordermanagement.controller.internal;

import com.ayush.ordermanagement.service.ProductAddonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/internal/product-addon")
@RequiredArgsConstructor
public class ProductAddonController {

 ProductAddonService productAddonService;

 @PostMapping
 public void createProductAddon() {
  productAddonService.createProductAddon();
 }

 @GetMapping(":productAddonId")
 public void getProductAddon(@RequestParam String productAddonId) {
  productAddonService.getProductAddon();
 }

 }
