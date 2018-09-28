package com.unonothing.usermgmt.helper;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.NameInfoDTO;

import java.util.List;

// during creation of user
// ensure there is only one nameInfo
public class EnsureOneNameInfo {

    public static void check(List<NameInfoDTO> nameInfoDTOList) {
        if (nameInfoDTOList.size() > 1) {
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "name info", "multiple sets found");
        }
    }
}