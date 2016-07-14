package com.dayswideawake.webrobot.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LookupDefinition {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    private Site site;
    @OneToOne(cascade=CascadeType.ALL)
    private Selector selector;
    private Long intervalSeconds;
    private Long lastLookupAt;

    public LookupDefinition() {
    }

    public LookupDefinition(Site site, Selector selector, Long intervalSeconds) {
        this.site = site;
        this.selector = selector;
        this.intervalSeconds = intervalSeconds;
    }

    public Long getId() {
        return id;
    }

    public Site getSite() {
        return site;
    }

    public Selector getSelector() {
        return selector;
    }

    public Long getIntervalSeconds() {
        return intervalSeconds;
    }

    public Long getLastLookupAt() {
        return lastLookupAt;
    }

    public void setLastLookupAt(Long lastLookupAt) {
        this.lastLookupAt = lastLookupAt;
    }
    
    

}
