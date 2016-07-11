package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;

@Entity
public class XPathSelector extends Selector {

    private String xPathSelector;

    public XPathSelector() {
    }

    public XPathSelector(String xPathSelector) {
        this.xPathSelector = xPathSelector;
    }

    public String getxPathSelector() {
        return xPathSelector;
    }

}
