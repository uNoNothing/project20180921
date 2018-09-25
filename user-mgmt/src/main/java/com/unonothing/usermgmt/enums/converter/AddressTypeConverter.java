package com.unonothing.usermgmt.enums.converter;

import com.unonothing.usermgmt.enums.AddressType;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter(autoApply = true)
public class AddressTypeConverter implements AttributeConverter<AddressType, String> {

    @Override
    public String convertToDatabaseColumn(AddressType addressType) {
        return addressType.getType();
    }

    @Override
    public AddressType convertToEntityAttribute(String type) {
        for (AddressType addressType : AddressType.values()) {
            if (addressType.getType().equalsIgnoreCase(type)) {
                return addressType;
            }
        }
        throw ExceptionFactory.create(ExceptionType.ENUM_ERROR, "address type");
    }
}