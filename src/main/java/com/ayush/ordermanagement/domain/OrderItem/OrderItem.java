package com.ayush.ordermanagement.domain.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    String productId;
    Integer quantity;
    ProductSnapshot productSnapshot;
    Addons addons;
    Integer itemTotal;
}
