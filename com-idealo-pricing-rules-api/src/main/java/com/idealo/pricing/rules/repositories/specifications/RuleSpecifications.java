package com.idealo.pricing.rules.repositories.specifications;

import com.idealo.pricing.rules.entities.RuleEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.idealo.pricing.rules.utils.AppConst.SPEC_PRICING_RULE_IS_ACTIVE_COL;
import static com.idealo.pricing.rules.utils.AppConst.SPEC_PRICING_RULE_SKU_COL;

public class RuleSpecifications {

    public static Specification<RuleEntity> isActiveSpecification() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.<Boolean>get(SPEC_PRICING_RULE_IS_ACTIVE_COL), true);
    }

    public static Specification<RuleEntity> bySkuSpecification(List<String> sku) {
        return isActiveSpecification().and((root, query, criteriaBuilder) -> root.get(SPEC_PRICING_RULE_SKU_COL).in(sku));
    }
}
