package com.dayswideawake.webrobot.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dayswideawake.webrobot.core.entity.Lookup;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;

@Service
public class LookupServiceImpl implements LookupService {

    private ContentSelectorService contentSelectorService;

    @Autowired
    public LookupServiceImpl(ContentSelectorService contentSelectorService) {
        this.contentSelectorService = contentSelectorService;
    }

    public Lookup doLookup(LookupDefinition lookupDefinition) {
        List<String> selectedContent = contentSelectorService.selectContent(lookupDefinition.getSite(), lookupDefinition.getSelector());
        Lookup lookup = new Lookup(lookupDefinition, selectedContent, new Date());
        return lookup;
    }

}
