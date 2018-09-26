package com.unonothing.usermgmt.validator;

import com.unonothing.usermgmt.annotation.ValidUserName;
import com.unonothing.usermgmt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserNameValidator implements ConstraintValidator<ValidUserName, String> {

    private static final String USERNAME_PATTERN = "^[A-Za-z][A-Za-z0-9_-]{4,255}$";

    private Pattern pattern;
    private Matcher matcher;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (!StringUtils.isEmpty(value)) {
            if (!userInfoRepository.userNameExists(value)) {

                matcher = pattern.matcher(value);
                return matcher.matches();
            }
        }
        return false;
    }

    public UserNameValidator() {
        pattern = Pattern.compile(USERNAME_PATTERN);
    }
}