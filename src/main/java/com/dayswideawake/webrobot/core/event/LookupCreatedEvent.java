package com.dayswideawake.webrobot.core.event;

import org.springframework.context.ApplicationEvent;

import com.dayswideawake.webrobot.core.entity.Lookup;

public class LookupCreatedEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1128628994108162951L;
    
    private Lookup lookup;
    
    public LookupCreatedEvent(Object source, Lookup lookup) {
        super(source);
        this.lookup = lookup;
    }

    public Lookup getLookup() {
        return lookup;
    }

}
