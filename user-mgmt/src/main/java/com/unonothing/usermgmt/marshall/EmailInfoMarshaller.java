package com.unonothing.usermgmt.marshall;

import com.unonothing.usermgmt.dto.EmailInfoDTO;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.enums.EmailType;
import com.unonothing.usermgmt.model.EmailInfo;
import com.unonothing.usermgmt.model.PersonalInfo;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//Marshaller : We convert java object into DTO.
//Unmarshaller : We convert DTO into java object.
public class EmailInfoMarshaller {

    public static List<EmailInfoDTO> marshall(List<EmailInfo> emailInfoList) {
        List<EmailInfoDTO> emailInfoDTOList = new ArrayList<>();
        for (EmailInfo emailInfo : emailInfoList) {
            emailInfoDTOList.add(marshall(emailInfo));
        }
        return emailInfoDTOList;
    }

    private static EmailInfoDTO marshall(EmailInfo emailInfo) {

        PersonalInfoDTO personalInfoDTO = PersonalInfoMarshaller.marshall(emailInfo);

        EmailInfoDTO emailInfoDTO = new EmailInfoDTO(personalInfoDTO);

        emailInfoDTO.setUserId(emailInfo.getUserInfo().getId());

        if (emailInfo != null) {
            if (!StringUtils.isEmpty(emailInfo.getEmail())) {
                emailInfoDTO.setEmail(emailInfo.getEmail());
            }
            if (!StringUtils.isEmpty(emailInfo.getType().getType())) {
                emailInfoDTO.setType(emailInfo.getType().getType());
            }
        }

        return emailInfoDTO;
    }

    public static List<EmailInfo> unmarshall(List<EmailInfoDTO> emailInfoDTOList, UserInfo userInfo) {
        List<EmailInfo> emailInfoList = new ArrayList<>();
        for (EmailInfoDTO emailInfoDTO : emailInfoDTOList) {
            emailInfoList.add(unmarshall(emailInfoDTO, userInfo));
        }
        return emailInfoList;
    }

    private static EmailInfo unmarshall(EmailInfoDTO emailInfoDTO, UserInfo userInfo) {

        PersonalInfo personalInfo = PersonalInfoMarshaller.unmarshall(emailInfoDTO);

        EmailInfo emailInfo = new EmailInfo(personalInfo);

        emailInfo.setUserInfo(userInfo);

        if (emailInfoDTO != null) {
            if (!StringUtils.isEmpty(emailInfoDTO.getEmail())) {
                emailInfo.setEmail(emailInfoDTO.getEmail());
            }
            if (!StringUtils.isEmpty(emailInfoDTO.getType())) {
                emailInfo.setType(EmailType.getEnum(emailInfoDTO.getType()));
            }

        }

        return emailInfo;
    }
}