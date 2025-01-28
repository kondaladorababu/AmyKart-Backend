package com.myProject.APIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerRegistry {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerRegistry.class, args);
    }

}
