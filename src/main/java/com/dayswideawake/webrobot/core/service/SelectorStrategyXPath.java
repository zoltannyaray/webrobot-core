package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.SelectorXPath;

@Service
public class SelectorStrategyXPath implements SelectorStrategy<SelectorXPath> {

    @Override
    public List<String> select(String content, SelectorXPath selector) {
        return null;
    }

}
