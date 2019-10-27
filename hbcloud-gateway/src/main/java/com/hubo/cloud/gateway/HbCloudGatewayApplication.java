package com.hubo.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
//@EnableDiscoveryClient
//@SpringBootApplication
public class HbCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudGatewayApplication.class, args);
    }
}
