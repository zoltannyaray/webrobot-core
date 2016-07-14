package com.dayswideawake.webrobot.core.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.config.AppConfig;
import com.dayswideawake.webrobot.core.entity.CssSelector;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;
import com.dayswideawake.webrobot.core.entity.Site;
import com.dayswideawake.webrobot.core.repository.LookupDefinitionRepository;

@ContextConfiguration(classes=AppConfig.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class LookupDefintionServiceImplTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private LookupDefintionServiceImpl lookupDefintionService;
    @Autowired
    private LookupDefinitionRepository lookupDefinitionRepository;
    
    @Test
    @Transactional
    public void getLookupDefintionsForScheduleShouldReturnCorrectNumberOfLookupDefintions(){
        for( int i = 0; i < 6; i++) {
            LookupDefinition lookupDefinition = new LookupDefinition(new Site(), new CssSelector(), 35L);
            Calendar lastLookupAt = Calendar.getInstance();
            lastLookupAt.add(Calendar.SECOND, -i * 10);
            lookupDefinition.setLastLookupAt(lastLookupAt.getTimeInMillis());
            lookupDefinitionRepository.save(lookupDefinition);
        }
        List<LookupDefinition> lookupDefintions = lookupDefintionService.getLookupDefintionsForSchedule(100);
        Assert.assertEquals(lookupDefintions.size(), 4);
    }
    
    
}
