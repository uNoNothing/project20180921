package com.unonothing.common.enums;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PhoneTypeConverter implements AttributeConverter<PhoneType, String> {

    @Override
    public String convertToDatabaseColumn(PhoneType phoneType) {
        return phoneType.getType();
    }

    @Override
    public PhoneType convertToEntityAttribute(String type) {
        for (PhoneType phoneType : PhoneType.values()) {
            if (phoneType.getType().equalsIgnoreCase(type)) {
                return phoneType;
            }
        }

        throw ExceptionFactory.create(ExceptionType.ENUM_ERROR, "PhoneType enum");
    }
}
