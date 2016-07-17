package com.dayswideawake.webrobot.core.entity;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private URL url;

    public Location() {
    }

    public Location(URL url) {
        super();
        this.url = url;
    }

    public Location(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

}
