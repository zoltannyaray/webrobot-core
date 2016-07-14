package com.dayswideawake.webrobot.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.config.AppConfig;
import com.dayswideawake.webrobot.core.entity.CssSelector;
import com.dayswideawake.webrobot.core.entity.Location;
import com.dayswideawake.webrobot.core.entity.Lookup;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;
import com.dayswideawake.webrobot.core.entity.Site;

@ContextConfiguration(classes=AppConfig.class)
public class LookupServiceImplTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private LookupServiceImpl lookupService;
    
    @Test
    public void doLookupForBodyShouldReturnCorrectLookup(){
        Site site = new Site(new Location("http://index.hu"));
        CssSelector selector = new CssSelector("body");
        LookupDefinition lookupDefinition = new LookupDefinition(site, selector, 10L);
        Lookup lookup = lookupService.doLookup(lookupDefinition);
        Assert.assertEquals(lookup.getSelectedContent().size(), 1);
    }
    
    @Test
    public void doLookupShouldSelectHeaderLogo(){
        Site site = new Site(new Location("http://index.hu"));
        CssSelector selector = new CssSelector(".index-header-wrapper .logo");
        LookupDefinition lookupDefinition = new LookupDefinition(site, selector, 10L);
        Lookup lookup = lookupService.doLookup(lookupDefinition);
        Assert.assertEquals(lookup.getSelectedContent().size(), 1);
        Assert.assertEquals(lookup.getSelectedContent().get(0), "<a class=\"logo\" href=\"/\"></a>");
    }
    
}
