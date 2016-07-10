package com.dayswideawake.webrobot.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Selector {

    @Id
    @GeneratedValue
    private Long id;
    
    public abstract List<String> select(String content);
    
}
