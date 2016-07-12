package com.dayswideawake.webrobot.core.service;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.entity.CssSelector;

public class SelectorStrategyCssTest {
  
    private SelectorStrategyCss selectorStrategyCss;
    private String content;
    
    @BeforeMethod
    public void init(){
        selectorStrategyCss = new SelectorStrategyCss();
        content = "<html><body><p id=\"id1\">Test</p><p class=\"class1\">Test 2</p></body></html>";
    }
    
    @Test
    public void selectShouldSelectBody(){
        List<String> selectedContent = selectorStrategyCss.select(content, new CssSelector("body"));
        Assert.assertEquals(selectedContent, Arrays.asList("<body><p id=\"id1\">Test</p><p class=\"class1\">Test 2</p></body>"));
    }
    
    @Test
    public void selectShouldSelectMultiplePs(){
        List<String> selectedContent = selectorStrategyCss.select(content, new CssSelector("p"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p id=\"id1\">Test</p>", "<p class=\"class1\">Test 2</p>"));
    }
    
    @Test
    public void selectShouldSelectByClass(){
        List<String> selectedContent = selectorStrategyCss.select(content, new CssSelector(".class1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p class=\"class1\">Test 2</p>"));
    }
    
    @Test
    public void selectShouldSelectById(){
        List<String> selectedContent = selectorStrategyCss.select(content, new CssSelector("#id1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p id=\"id1\">Test</p>"));
    }
    
    @Test
    public void selectShouldSelectByFollowing(){
        List<String> selectedContent = selectorStrategyCss.select(content, new CssSelector("#id1 + .class1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p class=\"class1\">Test 2</p>"));
    }
    
}
