package com.dayswideawake.webrobot.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Selector;

@Service
public class SelectorStrategyLocatorImpl implements SelectorStrategyLocator {

    private ApplicationContext applicationContext;

    @Autowired
    public SelectorStrategyLocatorImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T extends Selector> SelectorStrategy<T> getSelectorStrategyFor(Class<T> selectorClass) {
        return applicationContext.getBean(SelectorStrategy.class);
    }

    

}
