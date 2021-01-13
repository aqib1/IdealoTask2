package com.idealo.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 * This is the main class for starting idealo checkout service
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@SpringBootApplication
@EnableEurekaClient
public class CheckoutServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckoutServiceApplication.class, args);
    }
}
