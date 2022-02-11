package com.hubo.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HbCloudAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudAuthApplication.class, args);
    }
}
