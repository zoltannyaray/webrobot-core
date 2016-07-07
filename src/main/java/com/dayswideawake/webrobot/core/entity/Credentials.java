package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Credentials {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String password;
    
    public Credentials() {
    }
    
    public Credentials(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
}
