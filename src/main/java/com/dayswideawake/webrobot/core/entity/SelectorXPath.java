package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;

@Entity
public class SelectorXPath extends Selector {

    private String xPathSelector;

    public SelectorXPath() {
    }

    public SelectorXPath(String xPathSelector) {
        this.xPathSelector = xPathSelector;
    }

    public String getxPathSelector() {
        return xPathSelector;
    }

}
