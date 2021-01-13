package com.idealo.product.repositories.specifications;

import com.idealo.product.entities.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

import static com.idealo.product.utils.AppConst.*;

public class ProductSpecifications {

    private static Specification<ProductEntity> quantitySpecification() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get(SPEC_PRODUCT_QUANTITY_COL), 0);
    }

    public static Specification<ProductEntity> isActiveSpecification() {
        return quantitySpecification().and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Boolean>get(SPEC_PRODUCT_IS_ACTIVE_COL), true));
    }

    public static Specification<ProductEntity> bySkuSpecification(List<String> sku) {
        return isActiveSpecification().and((root, query, criteriaBuilder) -> root.get(SPEC_PRODUCT_SKU_COL).in(sku));
    }
}
