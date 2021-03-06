package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;

@Repository
public interface LookupDefinitionRepository extends JpaRepository<LookupDefinition, Long>, QueryDslPredicateExecutor<LookupDefinition>{

    
    
}
