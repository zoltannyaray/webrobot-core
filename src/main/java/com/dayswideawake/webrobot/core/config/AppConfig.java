package com.dayswideawake.webrobot.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DbConfig.class)
@ComponentScan(basePackages="com.dayswideawake.webrobot.core.service")
public class AppConfig {
    
}
