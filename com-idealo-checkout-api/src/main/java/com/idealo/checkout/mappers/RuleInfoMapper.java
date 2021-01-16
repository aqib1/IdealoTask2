package com.idealo.checkout.mappers;

import com.idealo.checkout.model.ProductShortResponse;
import com.idealo.checkout.model.RuleInfoRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleInfoMapper {
    RuleInfoRequest toRuleInfoRequest(ProductShortResponse response);

    List<RuleInfoRequest> toRuleInfoRequestList(List<ProductShortResponse> responses);
}
