package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dayswideawake.webrobot.core.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

}
