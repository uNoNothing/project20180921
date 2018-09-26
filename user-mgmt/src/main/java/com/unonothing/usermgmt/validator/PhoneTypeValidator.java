package com.unonothing.usermgmt.validator;

import com.unonothing.usermgmt.annotation.ValidPhoneType;
import com.unonothing.usermgmt.enums.converter.PhoneTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneTypeValidator implements ConstraintValidator<ValidPhoneType, String> {

    @Autowired
    private PhoneTypeConverter phoneTypeConverter;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isEmpty(value)) {
            if (phoneTypeConverter.convertToEntityAttribute(value) != null) {
                return true;
            }
        }
        return false;
    }
}
