package com.ayush.ordermanagement.service;

import com.ayush.ordermanagement.domain.Order.Order;

public interface OrderService {
    Order createOrder();
    Order getOrder();
}
