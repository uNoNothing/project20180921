package com.unonothing.usermgmt.validator;

import com.unonothing.usermgmt.annotation.ValidEmailType;
import com.unonothing.usermgmt.enums.converter.EmailTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailTypeValidator implements ConstraintValidator<ValidEmailType, String> {

    @Autowired
    private EmailTypeConverter emailTypeConverter;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isEmpty(value)) {
            if (emailTypeConverter.convertToEntityAttribute(value) != null) {
                return true;
            }
        }
        return false;
    }
}