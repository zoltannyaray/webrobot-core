package com.dayswideawake.webrobot.core.repository;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.Application;
import com.dayswideawake.webrobot.core.entity.Location;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;
import com.dayswideawake.webrobot.core.entity.Selector;
import com.dayswideawake.webrobot.core.entity.SelectorCss;
import com.dayswideawake.webrobot.core.entity.Site;

@SpringApplicationConfiguration(Application.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class LookupDefinitionRepositoryTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private LookupDefinitionRepository repository;
    
    @Test
    @Transactional
    public void entityShouldBeSaved() throws MalformedURLException{
        Location location = new Location("Test location", new URL("http://example.com"));
        Site site = new Site("Test site", location);
        Selector selector = new SelectorCss("body");
        LookupDefinition lookupDefinition = new LookupDefinition(site, selector, 10L);
        lookupDefinition = repository.save(lookupDefinition);
        Assert.assertNotNull(lookupDefinition.getId());
    }
    
    
}
