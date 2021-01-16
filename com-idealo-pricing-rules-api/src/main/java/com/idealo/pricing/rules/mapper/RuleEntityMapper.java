package com.idealo.pricing.rules.mapper;

import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleEntityMapper {

    RuleEntity toRuleEntity(RuleInfo info);

    List<RuleEntity> toRuleEntityList(List<RuleInfo> infos);
}
