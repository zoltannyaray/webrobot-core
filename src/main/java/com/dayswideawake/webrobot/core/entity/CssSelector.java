package com.dayswideawake.webrobot.core.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class CssSelector extends Selector {

    @ElementCollection
    private List<String> cssSelectors;

    @Override
    public List<String> select(String content) {
        return Arrays.asList(content);
    }
    
    
    
    
}
