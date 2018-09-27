package com.unonothing.usermgmt.marshall;

import com.unonothing.usermgmt.dto.NameInfoDTO;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.model.NameInfo;
import com.unonothing.usermgmt.model.PersonalInfo;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//Marshaller : We convert java object into DTO.
//Unmarshaller : We convert DTO into java object.
public class NameInfoMarshaller {

    public static List<NameInfoDTO> marshall(List<NameInfo> nameInfoList) {
        List<NameInfoDTO> nameInfoDTOList = new ArrayList<>();
        for (NameInfo nameInfo : nameInfoList) {
            nameInfoDTOList.add(marshall(nameInfo));
        }
        return nameInfoDTOList;
    }

    private static NameInfoDTO marshall(NameInfo nameInfo) {

        PersonalInfoDTO personalInfoDTO = PersonalInfoMarshaller.marshall(nameInfo);

        NameInfoDTO nameInfoDTO = new NameInfoDTO(personalInfoDTO);

        nameInfoDTO.setUserId(nameInfo.getUserInfo().getId());

        if (nameInfo != null) {
            if (!StringUtils.isEmpty(nameInfo.getTitle())) {
                nameInfoDTO.setTitle(nameInfo.getTitle());
            }
            if (!StringUtils.isEmpty(nameInfo.getFirstName())) {
                nameInfoDTO.setFirstName(nameInfo.getFirstName());
            }
            if (!StringUtils.isEmpty(nameInfo.getMiddleName())) {
                nameInfoDTO.setMiddleName(nameInfo.getMiddleName());
            }
            if (!StringUtils.isEmpty(nameInfo.getLastName())) {
                nameInfoDTO.setLastName(nameInfo.getLastName());
            }
        }

        return nameInfoDTO;
    }

    public static List<NameInfo> unmarshall(List<NameInfoDTO> nameInfoDTOList, UserInfo userInfo) {
        List<NameInfo> nameInfoList = new ArrayList<>();
        for (NameInfoDTO nameInfoDTO : nameInfoDTOList) {
            nameInfoList.add(unmarshall(nameInfoDTO, userInfo));
        }
        return nameInfoList;
    }

    private static NameInfo unmarshall(NameInfoDTO nameInfoDTO, UserInfo userInfo) {

        PersonalInfo personalInfo = PersonalInfoMarshaller.unmarshall(nameInfoDTO);

        NameInfo nameInfo = new NameInfo(personalInfo);

        nameInfo.setUserInfo(userInfo);

        if (nameInfoDTO != null) {
            if (!StringUtils.isEmpty(nameInfoDTO.getTitle())) {
                nameInfo.setTitle(nameInfoDTO.getTitle());
            }
            if (!StringUtils.isEmpty(nameInfoDTO.getFirstName())) {
                nameInfo.setFirstName(nameInfoDTO.getFirstName());
            }
            if (!StringUtils.isEmpty(nameInfoDTO.getMiddleName())) {
                nameInfo.setMiddleName(nameInfoDTO.getMiddleName());
            }
            if (!StringUtils.isEmpty(nameInfoDTO.getLastName())) {
                nameInfo.setLastName(nameInfoDTO.getLastName());
            }
        }

        return nameInfo;

    }

}
