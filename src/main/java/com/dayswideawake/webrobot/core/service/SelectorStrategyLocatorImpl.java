package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Selector;

@Service
public class SelectorStrategyLocatorImpl implements SelectorStrategyLocator {

//    private ApplicationContext applicationContext;
    
    @Autowired
    private List<SelectorStrategy<? extends Selector>> selectorStrategies;

//    @Autowired
//    public SelectorStrategyLocatorImpl(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }

    @Override
    public <T extends Selector> SelectorStrategy<T> getSelectorStrategyFor(T selector) {
//        SelectorStrategy<T> strategy = applicationContext.getBean(SelectorStrategy.class);
        SelectorStrategy<T> strategy = null;
        ResolvableType expectedType = ResolvableType.forClassWithGenerics(SelectorStrategy.class, selector.getClass());
        for(SelectorStrategy<? extends Selector> strategyToCheck: selectorStrategies) {
            if(expectedType.isInstance(strategyToCheck)){
                strategy = (SelectorStrategy<T>) strategyToCheck;
            }
        }
        if (strategy != null){
            return strategy;
        }
        else {
            throw new RuntimeException("SelectorStrategy could not been found for Selector");
        }
    }

    

}
