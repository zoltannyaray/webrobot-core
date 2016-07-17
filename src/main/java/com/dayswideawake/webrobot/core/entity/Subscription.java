package com.dayswideawake.webrobot.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Subscription {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Account account;
    @OneToOne
    private LookupDefinition lookupDefinition;
    @OneToMany
    private List<NotificationTarget> notificationTargets;

    public Subscription() {
    }

    public Subscription(Account account, LookupDefinition lookupDefinition) {
        this.account = account;
        this.lookupDefinition = lookupDefinition;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public LookupDefinition getLookupDefinition() {
        return lookupDefinition;
    }
    
}
