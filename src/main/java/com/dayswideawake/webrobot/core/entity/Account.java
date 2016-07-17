package com.dayswideawake.webrobot.core.entity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dayswideawake.webrobot.core.domain.model.EmailAddress;
import com.dayswideawake.webrobot.core.domain.model.HashedPassword;
import com.dayswideawake.webrobot.core.entity.converter.HashedPasswordConverter;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private EmailAddress emailAddress;
    @Convert(converter=HashedPasswordConverter.class)
    private HashedPassword password;
    @OneToMany
    private List<NotificationTarget> notificationTargets;

    public Account() {
    }

    public Account(EmailAddress emailAddress, HashedPassword password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress email) {
        this.emailAddress = email;
    }

    public HashedPassword getPassword() {
        return password;
    }

    public void setPassword(HashedPassword password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

}
