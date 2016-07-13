package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Selector;

@Service
public class SelectorStrategyLocatorImpl implements SelectorStrategyLocator {

    @Autowired
    private List<SelectorStrategy<? extends Selector>> allSelectorStrategies;

    @Override
    public <T extends Selector> SelectorStrategy<T> getSelectorStrategyFor(T selector) {
        ResolvableType neededStrategyType = ResolvableType.forClassWithGenerics(SelectorStrategy.class, selector.getClass());
        return allSelectorStrategies
                .stream()
                .filter(s -> neededStrategyType.isInstance(s))
                .map(s -> (SelectorStrategy<T>) s)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("SelectorStrategy<" + selector.getClass().getName() + "> could not been found"));
    }

}
