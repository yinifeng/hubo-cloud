package com.hubo.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringCloudApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringBootApplication
public class HbCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudGatewayApplication.class, args);
    }
}
