package com.dayswideawake.webrobot.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Site {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(cascade=CascadeType.ALL)
    private Location location;
    
    public Site() {
    }
    
    public Site(Location location) {
        this.location = location;
    }

    public Site(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

}
