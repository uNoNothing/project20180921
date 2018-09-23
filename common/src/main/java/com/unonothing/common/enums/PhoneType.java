package com.unonothing.common.enums;

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
}