package com.dayswideawake.webrobot.core.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(fixedRate=1000)
    public void doSomething(){
        System.out.println("Doing some thing... " + new Date().toString());
    }
    
}
