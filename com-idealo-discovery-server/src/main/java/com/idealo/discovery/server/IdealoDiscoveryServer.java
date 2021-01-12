package com.idealo.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IdealoDiscoveryServer {
    public static void main(String[] args) {
        SpringApplication.run(IdealoDiscoveryServer.class, args);
    }
}
