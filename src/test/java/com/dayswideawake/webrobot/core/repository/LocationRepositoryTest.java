package com.dayswideawake.webrobot.core.repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

@SpringApplicationConfiguration(Application.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class LocationRepositoryTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private LocationRepository repository;
    
    @Test
    @Transactional
    public void locationShouldBeCreated() throws MalformedURLException {
        Location location = new Location("Test location", new URL("http://example.com"));
        repository.save(location);
        Iterable<Location> locations = repository.findAll();
        Stream<Location> locationStream = StreamSupport.stream(locations.spliterator(), false);
        Assert.assertEquals(locationStream.count(), 1);
    }
    
    
}
