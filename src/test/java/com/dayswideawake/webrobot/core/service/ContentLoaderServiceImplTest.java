package com.dayswideawake.webrobot.core.service;

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
    public void loadContentShouldLoadHtml(){
        Site site = new Site(new Location("http://index.hu"));
        String content = service.loadContent(site);
        Assert.assertNotNull(content);
        Assert.assertNotEquals(content, "");
    }
    
}
