package com.dayswideawake.webrobot.core.service;

import java.util.List;

import com.dayswideawake.webrobot.core.entity.Selector;

public interface SelectorStrategy<T extends Selector> {

    public List<String> select(String content, T selector);
    
}
