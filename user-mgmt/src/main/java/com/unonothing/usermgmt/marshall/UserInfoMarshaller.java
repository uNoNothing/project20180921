package com.unonothing.usermgmt.marshall;

import com.unonothing.common.dto.BaseEntityAuditDTO;
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

    private static UserInfoDTO marshall(UserInfo userInfo) {

        BaseEntityAuditDTO baseEntityAuditDTO = BaseEntityAuditMarshaller.marshall(userInfo);

        UserInfoDTO userInfoDTO = new UserInfoDTO(baseEntityAuditDTO, userInfo.getUserName());

        if (!CollectionUtils.isEmpty(userInfo.getAddressInfoList())) {
            userInfoDTO.setAddressList(AddressInfoMarshaller.marshall(userInfo.getAddressInfoList()));
        }

        return userInfoDTO;
    }

    public static UserInfo unmarshall(UserInfoDTO userInfoDTO) {

        BaseEntityAudit baseEntityAudit = BaseEntityAuditMarshaller.unmarshall(userInfoDTO);

        UserInfo userInfo = new UserInfo(baseEntityAudit, userInfoDTO.getUserName());

        if (!CollectionUtils.isEmpty(userInfoDTO.getAddressList())) {
            userInfo.setAddressInfoList(AddressInfoMarshaller.unmarshall(userInfoDTO.getAddressList(), userInfo));
        }

        return userInfo;
    }

}
