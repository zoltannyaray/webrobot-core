package com.dayswideawake.webrobot.core.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.Selector;
import com.dayswideawake.webrobot.core.entity.Site;

@Service
public class ContentSelectorServiceImpl implements ContentSelectorService {

    @Autowired
    private ContentLoaderService contentLoaderService;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    public ContentSelectorServiceImpl(ContentLoaderService contentLoaderService) {
        this.contentLoaderService = contentLoaderService;
    }

    public List<String> selectContent(Site site, Selector selector) {
        String content = contentLoaderService.loadContent(site);
        return selector.select(content);
    }

    
    
}
