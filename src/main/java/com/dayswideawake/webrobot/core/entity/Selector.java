package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Selector {

    @Id
    @GeneratedValue
    private Long id;
    
}
