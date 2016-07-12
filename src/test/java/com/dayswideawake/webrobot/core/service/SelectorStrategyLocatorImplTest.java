package com.dayswideawake.webrobot.core.service;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.config.AppConfig;
import com.dayswideawake.webrobot.core.entity.CssSelector;
import com.dayswideawake.webrobot.core.entity.XPathSelector;

@ContextConfiguration(classes=AppConfig.class)
public class SelectorStrategyLocatorImplTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private SelectorStrategyLocatorImpl selectorStrategyLocator;
    @Mock
    private CssSelector cssSelector;
    @Mock
    private XPathSelector xPathSelector;
    
    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getSelectStrategyForShouldReturnCorrectStrategyForCssSelector(){
        SelectorStrategy<CssSelector> selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(new CssSelector());
        Assert.assertEquals(selectorStrategy.getClass(), SelectorStrategyCss.class);
    }
    
    @Test
    public void getSelectStrategyForShouldReturnCorrectStrategyForXPathSelector(){
        SelectorStrategy<XPathSelector> selectorStrategy = selectorStrategyLocator.getSelectorStrategyFor(new XPathSelector());
        Assert.assertEquals(selectorStrategy.getClass(), SelectorStrategyXPath.class);
    }
    
    
    
}
