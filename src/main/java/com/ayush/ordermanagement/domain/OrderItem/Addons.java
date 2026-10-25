package com.ayush.ordermanagement.domain.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addons {
    String addonId;
    String name;
    Integer unitPrice;
    Integer quantity;
}
