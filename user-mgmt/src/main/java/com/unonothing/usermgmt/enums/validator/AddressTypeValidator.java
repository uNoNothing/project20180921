package com.unonothing.usermgmt.enums.validator;

import com.unonothing.usermgmt.enums.converter.AddressTypeConverter;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AddressTypeValidator implements ConstraintValidator<ValidAddressType, String> {

    @Autowired
    private AddressTypeConverter addressTypeConverter;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isEmpty(value)) {
            if (addressTypeConverter.convertToEntityAttribute(value) != null) {
                return true;
            }
        }
        throw ExceptionFactory.create(ExceptionType.ENUM_ERROR, "address type");
    }
}