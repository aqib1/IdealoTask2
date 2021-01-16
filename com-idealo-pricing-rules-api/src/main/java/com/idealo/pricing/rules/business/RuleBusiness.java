package com.idealo.pricing.rules.business;

import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.exceptions.InvalidRequestException;
import com.idealo.pricing.rules.mapper.RuleEntityMapper;
import com.idealo.pricing.rules.mapper.RuleInfoMapper;
import com.idealo.pricing.rules.model.*;
import com.idealo.pricing.rules.services.Impl.RuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Component
public class RuleBusiness {
    @Autowired
    private RuleServiceImpl ruleService;

    @Autowired
    private RuleEntityMapper ruleEntityMapper;

    @Autowired
    private RuleInfoMapper ruleInfoMapper;

    public RuleResponse pricingRules(RuleRequest request) {
        validateRuleRequest(request);
        return ruleService.pricingRules(request);
    }

    public AddRuleResponse addRules(AddRuleRequest request) {
        validateAddRuleRequest(request);
        List<RuleEntity> savedEntities = ruleService.addRules(
                ruleEntityMapper.toRuleEntityList(request.getRuleInfos())
        );

        return new AddRuleResponse().message(
                String.format("%d number of rules are successfully inserted", savedEntities.size())
        );
    }

    public GetRulesResponse getAll() {
        return new GetRulesResponse().ruleInfos(
                ruleInfoMapper.toRuleInfoList(ruleService.getAll())
        );
    }

    public GetRulesResponse getBySku(GetRulesBySkuRequest request) {
        validateGetRulesBySkuRequest(request);
        return new GetRulesResponse().ruleInfos(
                ruleInfoMapper.toRuleInfoList(ruleService.getAll(request.getSkuList())));
    }
    
    public DropRulesResponse dropAll(DropRulesRequest request) {
        validateDropRulesRequest(request);
        ruleService.dropAll(request.getSkuList());
        return new DropRulesResponse().detailMessage("Rules drop successfully");
    }


    private void validateDropRulesRequest(DropRulesRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getSkuList())) {
            throw new InvalidRequestException("Request [sku-list] cannot be empty");
        }
    }

    private void validateGetRulesBySkuRequest(GetRulesBySkuRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getSkuList())) {
            throw new InvalidRequestException("Request [sku-list] cannot be empty");
        }
    }

    private void validateAddRuleRequest(AddRuleRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getRuleInfos())) {
            throw new InvalidRequestException("Request [rules] cannot be empty");
        }
    }

    private void validateRuleRequest(RuleRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getRuleInfoRequest())) {
            throw new InvalidRequestException("Request [pricingRuleRequests] cannot be empty");
        }
    }
}
