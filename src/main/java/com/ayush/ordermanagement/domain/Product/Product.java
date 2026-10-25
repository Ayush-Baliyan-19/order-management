package com.ayush.ordermanagement.domain.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    Integer productId;
    String name;
    String description;
    Integer currentPrice;
    Boolean isActive;
}
