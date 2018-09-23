package com.unonothing.common.enums;

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
}
