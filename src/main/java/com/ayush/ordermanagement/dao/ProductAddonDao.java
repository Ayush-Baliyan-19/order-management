
package com.ayush.ordermanagement.dao;

import com.ayush.ordermanagement.domain.ProductAddon.ProductAddon;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(ProductAddon.class)
public interface ProductAddonDao {

    @SqlUpdate("""
        INSERT INTO product_addons (
            product_id,
            addon_id,
            name,
            description,
            current_price,
            is_active
        )
        VALUES (
            :productId,
            :addonId,
            :name,
            :description,
            :currentPrice,
            :isActive
        )
        """)
    void createProductAddon(@BindBean ProductAddon addon);

    @SqlQuery("""
        SELECT product_id, addon_id, name, description,
               current_price, is_active
        FROM product_addons
        WHERE product_id = :productId
          AND addon_id = :addonId
        """)
    Optional<ProductAddon> getProductAddon(
            @Bind("productId") String productId,
            @Bind("addonId") String addonId
    );

    @SqlQuery("""
        SELECT product_id, addon_id, name, description,
               current_price, is_active
        FROM product_addons
        WHERE product_id = :productId
        ORDER BY addon_id
        """)
    List<ProductAddon> getAddonsByProductId(
            @Bind("productId") String productId
    );

    @SqlQuery("""
        SELECT product_id, addon_id, name, description,
               current_price, is_active
        FROM product_addons
        WHERE product_id = :productId
          AND is_active = true
        ORDER BY addon_id
        """)
    List<ProductAddon> getActiveAddonsByProductId(
            @Bind("productId") String productId
    );

    @SqlUpdate("""
        UPDATE product_addons
        SET name = :name,
            description = :description,
            current_price = :currentPrice,
            is_active = :isActive
        WHERE product_id = :productId
          AND addon_id = :addonId
        """)
    int updateProductAddon(@BindBean ProductAddon addon);

    @SqlUpdate("""
        UPDATE product_addons
        SET is_active = false
        WHERE product_id = :productId
          AND addon_id = :addonId
        """)
    int deactivateProductAddon(
            @Bind("productId") String productId,
            @Bind("addonId") String addonId
    );
}
