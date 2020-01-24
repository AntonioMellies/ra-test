package com.mellies.ra.api.companies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.mellies.ra.models")
public class CompaniesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompaniesApplication.class, args);
	}

}
