package com.security.amyKart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecurityLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLearnApplication.class, args);
	}

}
