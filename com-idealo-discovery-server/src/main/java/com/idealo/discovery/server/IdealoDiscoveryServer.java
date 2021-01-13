package com.idealo.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * This is the main class for starting idealo discovery server
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@EnableEurekaServer
@SpringBootApplication
public class IdealoDiscoveryServer {
    public static void main(String[] args) {
        SpringApplication.run(IdealoDiscoveryServer.class, args);
    }
}
