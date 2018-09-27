package com.unonothing.usermgmt.marshall;

import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.dto.PhoneInfoDTO;
import com.unonothing.usermgmt.enums.PhoneType;
import com.unonothing.usermgmt.model.PersonalInfo;
import com.unonothing.usermgmt.model.PhoneInfo;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//Marshaller : We convert java object into DTO.
//Unmarshaller : We convert DTO into java object.
public class PhoneInfoMarshaller {

    public static List<PhoneInfoDTO> marshall(List<PhoneInfo> phoneInfoList) {
        List<PhoneInfoDTO> phoneInfoDTOList = new ArrayList<>();
        for (PhoneInfo phoneInfo : phoneInfoList) {
            phoneInfoDTOList.add(marshall(phoneInfo));
        }
        return phoneInfoDTOList;
    }

    private static PhoneInfoDTO marshall(PhoneInfo phoneInfo) {

        PersonalInfoDTO personalInfoDTO = PersonalInfoMarshaller.marshall(phoneInfo);

        PhoneInfoDTO phoneInfoDTO = new PhoneInfoDTO(personalInfoDTO);

        phoneInfoDTO.setUserId(phoneInfo.getUserInfo().getId());

        if (phoneInfo != null) {
            if (!StringUtils.isEmpty(phoneInfo.getPhone())) {
                phoneInfoDTO.setPhone(phoneInfo.getPhone());
            }
            if (!StringUtils.isEmpty(phoneInfo.getType().getType())) {
                phoneInfoDTO.setType(phoneInfo.getType().getType());
            }
        }

        return phoneInfoDTO;
    }

    public static List<PhoneInfo> unmarshall(List<PhoneInfoDTO> phoneInfoDTOList, UserInfo userInfo) {
        List<PhoneInfo> phoneInfoList = new ArrayList<>();
        for (PhoneInfoDTO phoneInfoDTO : phoneInfoDTOList) {
            phoneInfoList.add(unmarshall(phoneInfoDTO, userInfo));
        }
        return phoneInfoList;
    }

    private static PhoneInfo unmarshall(PhoneInfoDTO phoneInfoDTO, UserInfo userInfo) {

        PersonalInfo personalInfo = PersonalInfoMarshaller.unmarshall(phoneInfoDTO);

        PhoneInfo phoneInfo = new PhoneInfo(personalInfo);

        phoneInfo.setUserInfo(userInfo);

        if (phoneInfoDTO != null) {
            if (!StringUtils.isEmpty(phoneInfoDTO.getPhone())) {
                phoneInfo.setPhone(phoneInfoDTO.getPhone());
            }
            if (!StringUtils.isEmpty(phoneInfoDTO.getType())) {
                phoneInfo.setType(PhoneType.getEnum(phoneInfoDTO.getType()));
            }

        }

        return phoneInfo;
    }
}
