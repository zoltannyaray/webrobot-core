package com.dayswideawake.webrobot.core.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Lookup {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private LookupDefinition lookupDefintion;
    @ElementCollection
    private List<String> selectedContent;

    public Lookup() {
    }

    public Lookup(LookupDefinition lookupDefintion, List<String> selectedContent) {
        this.lookupDefintion = lookupDefintion;
        this.selectedContent = selectedContent;
    }

    public Long getId() {
        return id;
    }

    public LookupDefinition getCheck() {
        return lookupDefintion;
    }

    public List<String> getSelectedContent() {
        return selectedContent;
    }

}
