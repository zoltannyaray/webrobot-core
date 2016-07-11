package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.XPathSelector;

@Service
public class SelectorStrategyXPath implements SelectorStrategy<XPathSelector> {

    @Override
    public List<String> select(String content, XPathSelector selector) {
        return null;
    }

}
