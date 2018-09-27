package com.unonothing.usermgmt.marshall;

import com.unonothing.common.dto.BaseAuditDTO;
import com.unonothing.common.marshall.BaseEntityAuditMarshaller;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.dto.UserInfoDTO;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UserInfoMarshaller {

    public static List<UserInfoDTO> marshall(List<UserInfo> userInfoList) {

        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
        for (UserInfo userInfo : userInfoList) {
            userInfoDTOList.add(marshall(userInfo));
        }

        return userInfoDTOList;
    }

    public static UserInfoDTO marshall(UserInfo userInfo) {

        BaseAuditDTO baseEntityAuditDTO = BaseEntityAuditMarshaller.marshall(userInfo);

        UserInfoDTO userInfoDTO = new UserInfoDTO(baseEntityAuditDTO, userInfo.getUserName());

        if (!CollectionUtils.isEmpty(userInfo.getAddressInfoList())) {
            userInfoDTO.setAddressList(AddressInfoMarshaller.marshall(userInfo.getAddressInfoList()));
        }

        if (!CollectionUtils.isEmpty(userInfo.getNameInfoList())) {
            userInfoDTO.setNameList(NameInfoMarshaller.marshall(userInfo.getNameInfoList()));
        }

        if (!CollectionUtils.isEmpty(userInfo.getEmailInfoList())) {
            userInfoDTO.setEmailList(EmailInfoMarshaller.marshall(userInfo.getEmailInfoList()));
        }

        if (!CollectionUtils.isEmpty(userInfo.getPhoneInfoList())) {
            userInfoDTO.setPhoneList(PhoneInfoMarshaller.marshall(userInfo.getPhoneInfoList()));
        }

        return userInfoDTO;
    }

    public static UserInfo unmarshall(UserInfoDTO userInfoDTO) {

        BaseEntityAudit baseEntityAudit = BaseEntityAuditMarshaller.unmarshall(userInfoDTO);

        UserInfo userInfo = new UserInfo(baseEntityAudit, userInfoDTO.getUserName());

        if (!CollectionUtils.isEmpty(userInfoDTO.getAddressList())) {
            userInfo.setAddressInfoList(AddressInfoMarshaller.unmarshall(userInfoDTO.getAddressList(), userInfo));
        }

        if (!CollectionUtils.isEmpty(userInfoDTO.getNameList())) {
            userInfo.setNameInfoList(NameInfoMarshaller.unmarshall(userInfoDTO.getNameList(), userInfo));
        }

        if (!CollectionUtils.isEmpty(userInfoDTO.getEmailList())) {
            userInfo.setEmailInfoList(EmailInfoMarshaller.unmarshall(userInfoDTO.getEmailList(), userInfo));
        }

        return userInfo;
    }

}
