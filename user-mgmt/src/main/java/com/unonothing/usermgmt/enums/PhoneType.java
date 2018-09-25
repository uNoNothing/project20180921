package com.unonothing.usermgmt.enums;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum PhoneType {

    MOBILE("Mobile"),
    WORK("Work"),
    HOME("Home"),
    WORK_FAX("Work Fax"),
    HOME_FAX("Home Fax"),
    OTHER("Other");

    private String type;

    public static PhoneType getEnum(String type) {
        for (PhoneType phoneType : PhoneType.values()) {
            if (phoneType.getType().equalsIgnoreCase(type)) {
                return phoneType;
            }
        }
        throw ExceptionFactory.create(ExceptionType.ENUM_ERROR, "phone type");
    }
}