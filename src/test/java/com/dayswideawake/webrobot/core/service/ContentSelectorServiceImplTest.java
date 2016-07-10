package com.dayswideawake.webrobot.core.service;

import java.util.Arrays;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.entity.CssSelector;
import com.dayswideawake.webrobot.core.entity.Site;

public class ContentSelectorServiceImplTest {
  
    private ContentSelectorServiceImpl service;
    @Mock
    private ContentLoaderService contentLoaderService;
    @Mock
    private Site site;
    
    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(contentLoaderService.loadContent(Mockito.any(Site.class))).thenReturn("<html><body><p id=\"id1\">Test</p><p class=\"class1\">Test 2</p></body></html>");
        service = new ContentSelectorServiceImpl(contentLoaderService);
    }
    
    @Test
    public void selectContentShouldSelectBody(){
        List<String> selectedContent = service.selectContent(site, new CssSelector("body"));
        Assert.assertEquals(selectedContent, Arrays.asList("<body><p id=\"id1\">Test</p><p class=\"class1\">Test 2</p></body>"));
    }
    
    @Test
    public void selectContentShouldSelectMultiplePs(){
        List<String> selectedContent = service.selectContent(site, new CssSelector("p"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p id=\"id1\">Test</p>", "<p class=\"class1\">Test 2</p>"));
    }
    
    @Test
    public void selectContentShouldSelectByClass(){
        List<String> selectedContent = service.selectContent(site, new CssSelector(".class1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p class=\"class1\">Test 2</p>"));
    }
    
    @Test
    public void selectContentShouldSelectById(){
        List<String> selectedContent = service.selectContent(site, new CssSelector("#id1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p id=\"id1\">Test</p>"));
    }
    
    @Test
    public void selectContentShouldSelectByFollowing(){
        List<String> selectedContent = service.selectContent(site, new CssSelector("#id1 + .class1"));
        Assert.assertEquals(selectedContent, Arrays.asList("<p class=\"class1\">Test 2</p>"));
    }
    
    
}
