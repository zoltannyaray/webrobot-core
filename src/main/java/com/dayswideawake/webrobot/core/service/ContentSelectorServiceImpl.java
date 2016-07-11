package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Selector;
import com.dayswideawake.webrobot.core.entity.Site;

@Service
public class ContentSelectorServiceImpl implements ContentSelectorService {

    private ContentLoaderService contentLoaderService;
    private SelectorStrategyLocator selectorStrategyLocator;
    
    @Autowired
    public ContentSelectorServiceImpl(ContentLoaderService contentLoaderService, SelectorStrategyLocator selectorStrategyLocator) {
        this.contentLoaderService = contentLoaderService;
        this.selectorStrategyLocator = selectorStrategyLocator;
    }

    @Override
    public <T extends Selector> List<String> selectContent(Site site, T selector) {
        String content = contentLoaderService.loadContent(site);
        SelectorStrategy<T> selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(selector);
        System.out.println(selectorStrategy.getClass().toGenericString());
        return selectorStrategy.select(content, selector);
    }

}
