package com.dayswideawake.webrobot.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.LookupDefinition;
import com.dayswideawake.webrobot.core.entity.QLookupDefinition;
import com.dayswideawake.webrobot.core.repository.LookupDefinitionRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class LookupDefintionServiceImpl implements LookupDefintionService {

    private LookupDefinitionRepository lookupDefinitionRepository;
    
    @Autowired
    public LookupDefintionServiceImpl(LookupDefinitionRepository lookupDefinitionRepository) {
        this.lookupDefinitionRepository = lookupDefinitionRepository;
    }

    @Override
    public List<LookupDefinition> getLookupDefintionsForSchedule(int maxNumberOfLookupDefintions) {
        QLookupDefinition lookupDefinition = QLookupDefinition.lookupDefinition;
        Long currentTimeStamp = new Date().getTime();
        BooleanExpression lastLookupWasMoreThanIntervalSecondsAgo = lookupDefinition.lastLookupAt.add(lookupDefinition.intervalSeconds.multiply(1000)).goe(currentTimeStamp);
        Iterable<LookupDefinition> lookupDefinitions = lookupDefinitionRepository.findAll(lastLookupWasMoreThanIntervalSecondsAgo);
        List<LookupDefinition> result = new ArrayList<>();
        lookupDefinitions.forEach(result::add);
        return result;
    }

}
