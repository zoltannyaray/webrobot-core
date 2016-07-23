package com.dayswideawake.webrobot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages="com.dayswideawake.webrobot.core.entity")
//@ComponentScan(basePackages="com.dayswideawake.webrobot.core")
//@EnableJpaRepositories(basePackages="com.dayswideawake.webrobot.core.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
}
