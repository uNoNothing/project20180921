package com.unonothing.usermgmt.validator;

import com.unonothing.usermgmt.annotation.ValidAddressType;
import com.unonothing.usermgmt.converter.AddressTypeConverter;
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
        return false;
    }
}