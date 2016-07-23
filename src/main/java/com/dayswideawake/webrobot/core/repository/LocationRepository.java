package com.dayswideawake.webrobot.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.dayswideawake.webrobot.core.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, QueryDslPredicateExecutor<Location> {

}
