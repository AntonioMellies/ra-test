package com.mellies.ra.api.complaints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EntityScan("com.mellies.ra.models")
public class ComplaintsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintsApplication.class, args);
    }

}
