package com.idealo.product.repositories;

import com.idealo.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * This is the class for product repository
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
