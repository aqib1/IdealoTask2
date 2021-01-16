package com.idealo.pricing.rules.mapper;

import com.idealo.pricing.rules.model.RuleInfoRequest;
import com.idealo.pricing.rules.model.RuleInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RuleInfoResponseMapper {
    RuleInfoResponse toRuleInfoResponse(RuleInfoRequest ruleInfoRequest);
}
