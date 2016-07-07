package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;

    public Location() {
    }

    public Location(String url) {
        super();
        this.url = url;
    }

    public Location(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
