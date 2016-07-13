package com.dayswideawake.webrobot.core.service;

import java.util.List;

import com.dayswideawake.webrobot.core.entity.LookupDefinition;

public interface LookupDefintionService {

    List<LookupDefinition> getLookupDefintionsForSchedule(int maxNumberOfLookupDefintions);

}
