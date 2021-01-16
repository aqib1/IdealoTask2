package com.idealo.pricing.rules.repositories;

import com.idealo.pricing.rules.entities.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RuleRepository extends JpaRepository<RuleEntity, Long>, JpaSpecificationExecutor<RuleEntity> {

    @Transactional
    @Modifying
    @Query("update PricingRule p set p.isActive = false where p.sku in (:sku) and p.isActive = true")
    void dropAll(List<String> sku);
}
