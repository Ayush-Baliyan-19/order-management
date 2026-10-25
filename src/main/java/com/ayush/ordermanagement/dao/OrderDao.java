
package com.ayush.ordermanagement.dao;

import com.ayush.ordermanagement.domain.Order.Order;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterConstructorMapper(Order.class)
public interface OrderDao {

    @SqlUpdate("""
        INSERT INTO orders (
            order_id,
            order_items,
            shipping_details,
            cart_total,
            created_at
        )
        VALUES (
            :orderId,
            :orderItems,
            :shippingDetails,
            :cartTotal,
            :createdAt
        )
        """)
    void createOrder(@BindBean Order order);

    @SqlQuery("""
        SELECT order_id,
               order_items,
               shipping_details,
               cart_total,
               created_at
        FROM orders
        WHERE order_id = :orderId
        """)
    Optional<Order> getOrderById(@Bind("orderId") String orderId);

    @SqlQuery("""
        SELECT order_id,
               order_items,
               shipping_details,
               cart_total,
               created_at
        FROM orders
        ORDER BY created_at DESC
        """)
    List<Order> getAllOrders();
}
