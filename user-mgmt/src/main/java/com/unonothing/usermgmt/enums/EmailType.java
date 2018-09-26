package com.unonothing.usermgmt.enums;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EmailType {

    PERSONAL("Personal"),
    WORK("Work"),
    OTHER("Other");

    private String type;

    public static EmailType getEnum(String type) {
        for (EmailType emailType : EmailType.values()) {
            if (emailType.getType().equalsIgnoreCase(type)) {
                return emailType;
            }
        }
        throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "Email type", type);
    }
}
