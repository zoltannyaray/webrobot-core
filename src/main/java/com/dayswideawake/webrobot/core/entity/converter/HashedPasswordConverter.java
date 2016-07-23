package com.dayswideawake.webrobot.core.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dayswideawake.webrobot.core.model.HashedPassword;

@Converter(autoApply=true)
public class HashedPasswordConverter implements AttributeConverter<HashedPassword, String>{

    @Override
    public String convertToDatabaseColumn(HashedPassword hashedPassword) {
        return hashedPassword.toString();
    }

    @Override
    public HashedPassword convertToEntityAttribute(String dbData) {
        return new HashedPassword(dbData);
    }

}
