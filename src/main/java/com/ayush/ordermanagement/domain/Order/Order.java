package com.ayush.ordermanagement.domain.Order;

import com.ayush.ordermanagement.domain.OrderItem.OrderItem;

import java.sql.Timestamp;

public class Order {
    String orderId;
    OrderStatus status;
    OrderItem[] items;
    Integer cartTotal;
    Timestamp createdAt;
}
