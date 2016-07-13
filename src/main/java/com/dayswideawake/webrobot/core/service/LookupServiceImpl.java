package com.dayswideawake.webrobot.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dayswideawake.webrobot.core.entity.Lookup;
import com.dayswideawake.webrobot.core.entity.LookupDefinition;
import com.dayswideawake.webrobot.core.repository.LookupRepository;

@Service
public class LookupServiceImpl implements LookupService {

    private ContentSelectorService contentSelectorService;
    private LookupRepository lookupRepository;
    
    @Autowired
    public LookupServiceImpl(ContentSelectorService contentSelectorService, LookupRepository lookupRepository) {
        this.contentSelectorService = contentSelectorService;
        this.lookupRepository = lookupRepository;
    }

    public Lookup doLookup(LookupDefinition lookupDefinition) {
        List<String> selectedContent = contentSelectorService.selectContent(lookupDefinition.getSite(), lookupDefinition.getSelector());
        Lookup lookup = new Lookup(lookupDefinition, selectedContent, new Date());
        lookup = lookupRepository.save(lookup);
        return lookup;
    }

}
