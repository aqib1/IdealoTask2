package com.idealo.pricing.rules.entities;

import com.idealo.pricing.rules.converters.RuleTypeConverter;
import com.idealo.pricing.rules.data.BaseEntity;
import com.idealo.pricing.rules.data.RuleTypes;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "PricingRule")
public class RuleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SKU", unique = true, nullable = false)
    private String sku;
    @Column(name = "ITEMS_FROM")
    private Long itemsFromApply;
    @Column(name = "DISCOUNT")
    private Long discount;
    @Column(name = "RULE_TYPE")
    @Convert(converter = RuleTypeConverter.class)
    private RuleTypes ruleType;
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
