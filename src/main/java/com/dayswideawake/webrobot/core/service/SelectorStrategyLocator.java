package com.dayswideawake.webrobot.core.service;

import com.dayswideawake.webrobot.core.entity.Selector;

public interface SelectorStrategyLocator {

    public <T extends Selector> SelectorStrategy<T> getSelectorStrategyFor(Class<T> selectorClass);
    
}
