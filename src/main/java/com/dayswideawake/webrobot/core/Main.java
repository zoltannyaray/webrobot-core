package com.dayswideawake.webrobot.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dayswideawake.webrobot.core.config.AppConfig;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ctx.start();
    }

}
