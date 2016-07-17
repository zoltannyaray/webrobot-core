package com.dayswideawake.webrobot.core.service;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.entity.SelectorCss;
import com.dayswideawake.webrobot.core.entity.Site;
import com.dayswideawake.webrobot.core.entity.SelectorXPath;

public class ContentSelectorServiceImplTest {
  
    private ContentSelectorServiceImpl service;
    @Mock
    private SelectorStrategyLocator selectorStrategyLocator;
    @Mock
    private ContentLoaderService contentLoaderService;
    @Mock
    private Site site;
    @Mock
    private SelectorStrategyCss selectorStrategyCss;
    @Mock
    private SelectorStrategyXPath selectorStrategyXPath;
    private String content = "test content";
    
    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(contentLoaderService.loadContent(Mockito.any(Site.class))).thenReturn(content);
        Mockito.when(selectorStrategyLocator.getSelectorStrategyFor(Mockito.isA(SelectorCss.class))).thenReturn(selectorStrategyCss);
        Mockito.when(selectorStrategyLocator.getSelectorStrategyFor(Mockito.isA(SelectorXPath.class))).thenReturn(selectorStrategyXPath);
        service = new ContentSelectorServiceImpl(contentLoaderService, selectorStrategyLocator);
    }
    
    @Test
    public void selectContentShouldUseCssSelectorStrategy(){
        SelectorCss selector = new SelectorCss("test selector");
        service.selectContent(site, selector);
        Mockito.verify(selectorStrategyCss, Mockito.times(1)).select(content, selector);
        Mockito.verify(selectorStrategyXPath, Mockito.never()).select(Mockito.any(), Mockito.any());
    }
    
    @Test
    public void selectContentShouldUseXPathSelectorStrategy(){
        SelectorXPath selector = new SelectorXPath("test selector");
        service.selectContent(site, selector);
        Mockito.verify(selectorStrategyXPath, Mockito.times(1)).select(content, selector);
        Mockito.verify(selectorStrategyCss, Mockito.never()).select(Mockito.any(), Mockito.any());
    }    
}
