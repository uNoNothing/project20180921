package com.unonothing.usermgmt.enums;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AddressType {

    HOME("Home"),
    WORK("Work"),
    OTHER("Other");

    private String type;

    public static AddressType getEnum(String type) {
        for (AddressType addressType : AddressType.values()) {
            if (addressType.getType().equalsIgnoreCase(type)) {
                return addressType;
            }
        }
        throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "Address type", type);
    }
}