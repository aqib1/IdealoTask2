package com.idealo.pricing.rules.initializer;

import com.idealo.pricing.rules.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.idealo.pricing.rules.utils.AppUtils.getInitRules;

@Component
@ConditionalOnProperty(name = "app.init-db", havingValue = "true")
public class DbInitializer implements CommandLineRunner {
    @Autowired
    private RuleRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.saveAll(getInitRules());
    }
}
