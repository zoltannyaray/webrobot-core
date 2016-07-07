package com.dayswideawake.webrobot.core.repository;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.config.AppConfig;
import com.dayswideawake.webrobot.core.entity.Location;

@ContextConfiguration(classes=AppConfig.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class LocationRepositoryTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private LocationRepository repository;
    
    @Test
    @Transactional
    public void locationShouldBeCreated() {
        Location location = new Location("Test location 2", "http://example.com");
        repository.save(location);
        Iterable<Location> locations = repository.findAll();
        Stream<Location> locationStream = StreamSupport.stream(locations.spliterator(), false);
        Assert.assertEquals(locationStream.count(), 1);
    }
    
    
}
