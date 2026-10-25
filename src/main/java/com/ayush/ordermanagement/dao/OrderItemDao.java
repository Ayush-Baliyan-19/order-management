
package com.ayush.ordermanagement.dao;

import com.ayush.ordermanagement.domain.OrderItem.OrderItem;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(OrderItem.class)
public interface OrderItemDao {

    @SqlUpdate("""
        INSERT INTO order_items (
            order_id,
            product_id,
            quantity,
            product_snapshot,
            addons,
            item_total
        )
        VALUES (
            :orderId,
            :productId,
            :quantity,
            :productSnapshot,
            :addons,
            :itemTotal
        )
        """)
    @GetGeneratedKeys("order_item_id")
    Long createOrderItem(@BindBean OrderItem orderItem);

    @SqlQuery("""
        SELECT order_id,
               product_id,
               quantity,
               product_snapshot,
               addons,
               item_total
        FROM order_items
        WHERE order_id = :orderId
        """)
    List<OrderItem> getOrderItemsByOrderId(
            @Bind("orderId") String orderId
    );

    @SqlQuery("""
        SELECT order_id,
               product_id,
               quantity,
               product_snapshot,
               addons,
               item_total
        FROM order_items
        WHERE order_id = :orderId
          AND product_id = :productId
        """)
    Optional<OrderItem> getOrderItem(
            @Bind("orderId") String orderId,
            @Bind("productId") String productId
    );

    @SqlUpdate("""
        UPDATE order_items
        SET quantity = :quantity,
            product_snapshot = :productSnapshot,
            addons = :addons,
            item_total = :itemTotal
        WHERE order_id = :orderId
          AND product_id = :productId
        """)
    int updateOrderItem(
            @Bind("orderId") String orderId,
            @BindBean OrderItem orderItem
    );

    @SqlUpdate("""
        DELETE FROM order_items
        WHERE order_id = :orderId
          AND product_id = :productId
        """)
    int deleteOrderItem(
            @Bind("orderId") String orderId,
            @Bind("productId") String productId
    );
}
