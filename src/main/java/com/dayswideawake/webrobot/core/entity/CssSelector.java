package com.dayswideawake.webrobot.core.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.select.Elements;

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

    @Override
    public List<String> select(String content) {
        Document document = Jsoup.parse(content);
        OutputSettings outputSettings = new OutputSettings();
        outputSettings.prettyPrint(false);
        document.outputSettings(outputSettings);
        Elements elements = document.select(cssSelector);
        return elements.stream().map((element) -> element.outerHtml()).collect(Collectors.toList());
    }

}
