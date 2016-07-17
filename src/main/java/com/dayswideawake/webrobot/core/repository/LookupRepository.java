package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.dayswideawake.webrobot.core.entity.Lookup;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, Long>, QueryDslPredicateExecutor<Lookup> {

    
    
}
