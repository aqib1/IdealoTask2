package com.idealo.pricing.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 * This is the main class for starting idealo pricing rules
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@SpringBootApplication
@EnableEurekaClient
public class PricingRulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingRulesApplication.class, args);
    }
}
