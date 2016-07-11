package com.dayswideawake.webrobot.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.dayswideawake.webrobot.core.entity.CssSelector;

@Service
public class SelectorStrategyCss implements SelectorStrategy<CssSelector>{

    @Override
    public List<String> select(String content, CssSelector selector) {
        Document document = Jsoup.parse(content);
        OutputSettings outputSettings = new OutputSettings();
        outputSettings.prettyPrint(false);
        document.outputSettings(outputSettings);
        Elements elements = document.select(selector.getCssSelector());
        return elements.stream().map((element) -> element.outerHtml()).collect(Collectors.toList());
    }

}
