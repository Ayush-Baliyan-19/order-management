package com.ayush.ordermanagement.service.impl;

import com.ayush.ordermanagement.domain.Order.Order;
import com.ayush.ordermanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder() {
        Order order = new Order();
        log.info("Creating order");
        log.warn("Order validation warning");
        log.error("Failed to create order");
        return order;
    }

    @Override
    public Order getOrder() {
        Order order = new Order();
        log.info("Your order is this");
        return order;
    }
}
