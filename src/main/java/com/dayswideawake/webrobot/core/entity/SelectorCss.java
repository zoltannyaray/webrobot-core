package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;

@Entity
public class SelectorCss extends Selector {

    private String cssSelector;

    public SelectorCss() {
    }

    public SelectorCss(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public String getCssSelector() {
        return cssSelector;
    }
}
