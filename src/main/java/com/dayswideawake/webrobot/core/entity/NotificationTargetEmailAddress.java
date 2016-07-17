package com.dayswideawake.webrobot.core.entity;

import javax.persistence.Entity;

import com.dayswideawake.webrobot.core.domain.model.EmailAddress;

@Entity
public class NotificationTargetEmailAddress extends NotificationTarget {

    private EmailAddress emailAddress;

    public NotificationTargetEmailAddress() {
    }

    public NotificationTargetEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
    
}
