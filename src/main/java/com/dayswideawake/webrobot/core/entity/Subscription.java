package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
