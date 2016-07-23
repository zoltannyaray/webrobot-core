package com.dayswideawake.webrobot.core.service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;

@Service
public class ScheduleService {

    private ThreadPoolTaskExecutor taskExecutor;
    private LookupService lookupService;
    private LookupDefintionService lookupDefintionService;

//    @Autowired
//    public ScheduleService(ThreadPoolTaskExecutor taskExecutor, LookupService lookupService, LookupDefintionService lookupDefintionService) {
//        this.taskExecutor = taskExecutor;
//        this.lookupService = lookupService;
//        this.lookupDefintionService = lookupDefintionService;
//    }
//
//    @Scheduled(fixedRate = 1000)
//    public void doLookups() {
//        List<LookupDefinition> lookupDefinitions = lookupDefintionService.getLookupDefintionsForSchedule(10);
//        try {
//            for (LookupDefinition lookupDefinition : lookupDefinitions) {
//                taskExecutor.submit(() -> lookupService.doLookup(lookupDefinition));
//            }
//        } catch (RejectedExecutionException ex) {
//        }
//    }

}
