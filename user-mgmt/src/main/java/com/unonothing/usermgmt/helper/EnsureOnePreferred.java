package com.unonothing.usermgmt.helper;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EnsureOnePreferred {

    public static void check(List<PersonalInfoDTO> personalInfoDTOList, String info) {

        if (personalInfoDTOList.size() > 1) {
            if (personalInfoDTOList
                    .stream()
                    .filter(personalInfo -> personalInfo.getPreferred().compareTo(true) == 0)
                    .collect(Collectors.toList())
                    .size() > 1) {
                throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, info.concat(" list"), "multiple preferred found");
            }
        }
    }
}
