package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;

@Entity
public class CssSelector extends Selector {

    private String cssSelector;

    public CssSelector() {
    }

    public CssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public String getCssSelector() {
        return cssSelector;
    }
}
