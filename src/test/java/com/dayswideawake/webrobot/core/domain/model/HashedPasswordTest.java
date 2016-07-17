package com.dayswideawake.webrobot.core.domain.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashedPasswordTest {
  
    @Test
    public void hashedPasswordsShouldBeEqualByValue(){
        Assert.assertEquals(new HashedPassword("password"), new HashedPassword("password"));
    }
    
    @Test
    public void hashedPasswordShouldBeEqualToItself(){
        HashedPassword hashedPassword = new HashedPassword("password");
        Assert.assertEquals(hashedPassword, hashedPassword);
    }
    
    @Test
    public void hashedPasswordsShouldNotBeEqual(){
        Assert.assertNotEquals(new HashedPassword("password1"), new HashedPassword("password2"));
    }
    
}
