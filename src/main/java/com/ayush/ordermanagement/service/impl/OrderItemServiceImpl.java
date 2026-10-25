package com.ayush.ordermanagement.service.impl;

import com.ayush.ordermanagement.domain.OrderItem.OrderItem;
import com.ayush.ordermanagement.service.OrderItemService;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public OrderItem createOrderItem() {
        return new OrderItem();
    }

    @Override
    public OrderItem getOrderItem() {
        return new OrderItem();
    }
}
