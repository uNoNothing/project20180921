package com.unonothing.usermgmt.converter;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.enums.EmailType;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter(autoApply = true)
public class EmailTypeConverter implements AttributeConverter<EmailType, String> {

    @Override
    public String convertToDatabaseColumn(EmailType emailType) {
        return emailType.getType();
    }

    @Override
    public EmailType convertToEntityAttribute(String type) {
        for (EmailType emailType : EmailType.values()) {
            if (emailType.getType().equalsIgnoreCase(type)) {
                return emailType;
            }
        }
        throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "Email type", type);

    }
}