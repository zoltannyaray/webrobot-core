package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;

@Repository
public interface LookupDefinitionRepository extends CrudRepository<LookupDefinition, Long>{

    
    
}
