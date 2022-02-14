package com.hubo.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HbCloudStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudStockApplication.class, args);
    }
}
