package com.ayush.ordermanagement.domain.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSnapshot {
    String name;
    String description;
    Integer unitPrice;
}
