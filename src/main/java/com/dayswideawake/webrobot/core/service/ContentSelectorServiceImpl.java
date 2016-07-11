package com.dayswideawake.webrobot.core.service;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
    public List<String> selectContent(Site site, Selector selector) {
        String content = contentLoaderService.loadContent(site);
//        SelectorStrategy<T> selectorStrategy = applicationContext.getBean(SelectorStrategy.class);
        SelectorStrategy selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(selector.getClass());
        System.out.println(selectorStrategy.getClass().toGenericString());
        return selectorStrategy.select(content, selector);
    }

}
