package com.idealo.pricing.rules.integeration.helper;

import com.idealo.pricing.rules.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.idealo.pricing.rules.utility.DataHelper.getAllRuleEntities;
import static com.idealo.pricing.rules.utility.DataHelper.getAllRuleEntitiesForDropApi;

@Component
public class DbHelper {
    @Autowired
    private RuleRepository repository;

    public void deleteAll() {
        repository.deleteAll();
    }

    public void initEntitiesInDatabase() {
        repository.saveAll(getAllRuleEntities());
    }

    public void initEntitiesForDropApi() {
        repository.saveAll(getAllRuleEntitiesForDropApi());
    }
}
