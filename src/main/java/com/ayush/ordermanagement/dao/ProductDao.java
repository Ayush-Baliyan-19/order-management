
package com.ayush.ordermanagement.dao;

import com.ayush.ordermanagement.domain.Product.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Product.class)
public interface ProductDao {

    @SqlUpdate("""
        INSERT INTO products (
            product_id,
            name,
            description,
            current_price,
            is_active
        )
        VALUES (
            :productId,
            :name,
            :description,
            :currentPrice,
            :isActive
        )
        """)
    int createProduct(@BindBean Product product);

    @SqlQuery("""
        SELECT *
        FROM products
        WHERE product_id = :productId
        """)
    Optional<Product> getProductById(
            @Bind("productId") Integer productId
    );

    @SqlQuery("""
        SELECT *
        FROM products
        WHERE is_active = true
        """)
    List<Product> getAllActiveProducts();

    @SqlUpdate("""
        UPDATE products
        SET name = :name,
            description = :description,
            current_price = :currentPrice,
            is_active = :isActive
        WHERE product_id = :productId
        """)
    int updateProduct(@BindBean Product product);

    @SqlUpdate("""
        UPDATE products
        SET is_active = false
        WHERE product_id = :productId
        """)
    int deactivateProduct(
            @Bind("productId") Integer productId
    );
}
