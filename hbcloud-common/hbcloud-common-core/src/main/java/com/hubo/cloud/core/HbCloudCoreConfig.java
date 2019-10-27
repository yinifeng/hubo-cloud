package com.hubo.cloud.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = HbCloudCoreConfig.class)
public class HbCloudCoreConfig {
}
