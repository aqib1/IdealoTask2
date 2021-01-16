package com.idealo.pricing.rules.services.Impl;

import com.google.common.collect.Lists;
import com.idealo.pricing.rules.data.RuleTypes;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.mapper.RuleInfoResponseMapper;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import com.idealo.pricing.rules.model.RuleInfoResponse;
import com.idealo.pricing.rules.model.RuleRequest;
import com.idealo.pricing.rules.model.RuleResponse;
import com.idealo.pricing.rules.repositories.RuleRepository;
import com.idealo.pricing.rules.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.idealo.pricing.rules.repositories.specifications.RuleSpecifications.bySkuSpecification;
import static com.idealo.pricing.rules.repositories.specifications.RuleSpecifications.isActiveSpecification;
import static com.idealo.pricing.rules.utils.AppUtils.*;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleRepository repository;

    @Autowired
    private RuleInfoResponseMapper ruleInfoResponseMapper;

    @Override
    public RuleResponse pricingRules(RuleRequest request) {
        Map<String, RuleInfoRequest> ruleInfoBySku = ruleInfoMapBySku(request.getRuleInfoRequest());
        Map<String, RuleEntity> ruleEntityBySku = ruleEntityBySku(repository.findAll(bySkuSpecification(
                getSkuListFromRuleInfo(request.getRuleInfoRequest()))));
        var response = new RuleResponse();
        response.setRuleInfoResponse(Lists.newArrayList());
        prepareResponse(response, ruleInfoBySku, ruleEntityBySku);
        return response;
    }

    @Override
    public List<RuleEntity> addRules(List<RuleEntity> ruleEntities) {
        return repository.saveAll(ruleEntities);
    }

    @Override
    public List<RuleEntity> getAll() {
        return repository.findAll(isActiveSpecification());
    }

    @Override
    public List<RuleEntity> getAll(List<String> skuList) {
        return repository.findAll(bySkuSpecification(skuList));
    }

    @Override
    public void dropAll(List<String> skuList) {
        repository.dropAll(skuList);
    }

    private void prepareResponse(RuleResponse response, Map<String, RuleInfoRequest> ruleInfoBySku, Map<String, RuleEntity> ruleEntityBySku) {
        var total = 0L;
        Iterator<String> skuIterator = ruleInfoBySku.keySet().iterator();
        while (skuIterator.hasNext()) {
            var key = skuIterator.next();
            Long currentPrice = 0l;
            RuleEntity ruleEntity = null;
            var ruleType = RuleTypes.NO;
            var ruleInfoRequest = ruleInfoBySku.get(key);
            var ruleInfoResponse = ruleInfoResponseMapper.toRuleInfoResponse(ruleInfoRequest);
            if (!ruleEntityBySku.containsKey(key)) {
                currentPrice = ruleType.getPricingRule().applyRule(ruleInfoRequest, null);
            } else {
                ruleEntity = ruleEntityBySku.get(key);
                ruleType = ruleEntity.getRuleType();
                currentPrice = ruleType.getPricingRule().applyRule(ruleInfoRequest, ruleEntity);
            }
            prepareDetailMessage(key, ruleInfoResponse, ruleEntity, ruleType);
            ruleInfoResponse.setSpecialPrice(currentPrice);
            response.getRuleInfoResponse().add(ruleInfoResponse);
            total += currentPrice;
        }
        response.setTotal(total);
    }

    private void prepareDetailMessage(String key, RuleInfoResponse ruleInfoResponse, RuleEntity ruleEntity, RuleTypes ruleType) {
        ruleInfoResponse.setDetailedMessage(ruleType.getDetails(key,
                ruleEntity.getItemsFromApply(), ruleEntity.getDiscount()));
    }
}
