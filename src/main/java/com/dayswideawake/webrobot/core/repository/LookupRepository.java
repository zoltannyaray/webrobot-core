package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dayswideawake.webrobot.core.entity.Lookup;

@Repository
public interface LookupRepository extends CrudRepository<Lookup, Long>{

    
    
}
