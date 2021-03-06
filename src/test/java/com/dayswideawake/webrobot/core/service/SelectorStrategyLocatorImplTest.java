package com.dayswideawake.webrobot.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.config.AppConfig;
import com.dayswideawake.webrobot.core.entity.SelectorCss;
import com.dayswideawake.webrobot.core.entity.SelectorXPath;

@ContextConfiguration(classes=AppConfig.class)
public class SelectorStrategyLocatorImplTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private SelectorStrategyLocatorImpl selectorStrategyLocator;
    
    @Test
    public void getSelectStrategyForShouldReturnCorrectStrategyForCssSelector(){
        SelectorStrategy<SelectorCss> selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(new SelectorCss());
        Assert.assertEquals(selectorStrategy.getClass(), SelectorStrategyCss.class);
    }
    
    @Test
    public void getSelectStrategyForShouldReturnCorrectStrategyForXPathSelector(){
        SelectorStrategy<SelectorXPath> selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(new SelectorXPath());
        Assert.assertEquals(selectorStrategy.getClass(), SelectorStrategyXPath.class);
    }
    
    
    
}
