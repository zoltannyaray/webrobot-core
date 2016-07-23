package com.dayswideawake.webrobot.core.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dayswideawake.webrobot.core.model.EmailAddress;

@Converter(autoApply=true)
public class EmailAddressConverter implements AttributeConverter<EmailAddress, String>{

    @Override
    public String convertToDatabaseColumn(EmailAddress emailAddress) {
        return emailAddress.toString();
    }

    @Override
    public EmailAddress convertToEntityAttribute(String dbData) {
        return new EmailAddress(dbData);
    }

}
