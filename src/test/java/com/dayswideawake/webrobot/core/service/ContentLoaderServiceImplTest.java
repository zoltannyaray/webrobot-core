package com.dayswideawake.webrobot.core.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.entity.Location;
import com.dayswideawake.webrobot.core.entity.Site;

public class ContentLoaderServiceImplTest {
  
    private ContentLoaderServiceImpl service;
    
    @BeforeMethod
    public void init(){
        service = new ContentLoaderServiceImpl();
    }
    
    @Test
    public void loadContentShouldLoadHtml() throws MalformedURLException{
        Site site = new Site(new Location(new URL("http://index.hu")));
        String content = service.loadContent(site);
        Assert.assertNotNull(content);
        Assert.assertNotEquals(content, "");
    }
    
}
