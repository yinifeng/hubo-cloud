package com.hubo.cloud.provider;

import com.hubo.cloud.core.HbCloudCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableDiscoveryClient
@EnableAspectJAutoProxy
@Configuration
@EnableAutoConfiguration
//@EnableTransactionManagement
@ComponentScan(basePackageClasses = {HbCloudCoreConfig.class,
        HbCloudUserApplication.class})
public class HbCloudUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(HbCloudUserApplication.class, args);
    }
}
