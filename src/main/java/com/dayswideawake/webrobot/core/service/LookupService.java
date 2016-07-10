package com.dayswideawake.webrobot.core.service;

import com.dayswideawake.webrobot.core.entity.Lookup;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;

public interface LookupService {

    public Lookup doLookup(LookupDefinition lookupDefinition);
    
}
