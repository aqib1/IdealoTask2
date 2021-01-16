package com.idealo.product.repositories;

import com.idealo.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 * This is the class for product repository
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {


    @Transactional
    @Modifying
    @Query("update Products p set p.isActive = false where p.sku in (:sku) and p.isActive = true")
    void dropAll(List<String> sku);
}
