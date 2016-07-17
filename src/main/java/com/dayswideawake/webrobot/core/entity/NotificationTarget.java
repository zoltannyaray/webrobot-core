package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class NotificationTarget {

    @Id
    @GeneratedValue
    private Long id;
    
}
