package com.dayswideawake.webrobot.core.service;

import java.util.List;

import com.dayswideawake.webrobot.core.entity.Selector;
import com.dayswideawake.webrobot.core.entity.Site;

public interface ContentSelectorService {

    public <T extends Selector> List<String> selectContent(Site site, T selector);
    
}
