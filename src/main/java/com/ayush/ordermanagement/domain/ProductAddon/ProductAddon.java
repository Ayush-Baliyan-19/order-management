package com.ayush.ordermanagement.domain.ProductAddon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductAddon {
    String productId;
    String addonId;
    String name;
    String description;
    String currentPrice;
    Boolean isActive;
}
