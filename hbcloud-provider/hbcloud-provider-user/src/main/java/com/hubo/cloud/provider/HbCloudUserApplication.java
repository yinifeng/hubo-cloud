package com.hubo.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableDiscoveryClient
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableFeignClients
public class HbCloudUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudUserApplication.class, args);
    }
}
