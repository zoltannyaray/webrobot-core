package com.dayswideawake.webrobot.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lookup {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToOne(cascade=CascadeType.ALL)
    private LookupDefinition lookupDefintion;
    @ElementCollection
    @Column(length=3000)
    private List<String> selectedContent;

    public Lookup() {
    }

    public Lookup(LookupDefinition lookupDefintion, List<String> selectedContent, Date createdAt) {
        this.lookupDefintion = lookupDefintion;
        this.selectedContent = selectedContent;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public LookupDefinition getLookupDefintion() {
        return lookupDefintion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<String> getSelectedContent() {
        return selectedContent;
    }

}
