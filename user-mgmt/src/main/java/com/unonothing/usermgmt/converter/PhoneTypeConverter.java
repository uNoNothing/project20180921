package com.unonothing.usermgmt.converter;

import com.unonothing.usermgmt.enums.PhoneType;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
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
        throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "Phone type", type);

    }
}
