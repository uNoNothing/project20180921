package com.unonothing.usermgmt.service;

import com.unonothing.common.utils.CurrentUser;
import com.unonothing.usermgmt.dto.UserInfoDTO;
import com.unonothing.usermgmt.marshall.UserInfoMarshaller;
import com.unonothing.usermgmt.model.UserInfo;
import com.unonothing.usermgmt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service("userInfoService")
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void create(UserInfoDTO userInfoDTO) {

        UserInfo userInfo = UserInfoMarshaller.unmarshall(userInfoDTO, CurrentUser.get());

        userInfoRepository.save(userInfo);

    }

    @Override
    public List<UserInfoDTO> read() {
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();

        List<UserInfo> userInfoList = userInfoRepository.findAll();

        if (!CollectionUtils.isEmpty(userInfoList)) {
            userInfoDTOList.addAll(UserInfoMarshaller.marshall(userInfoList));
        }

        return userInfoDTOList;

    }
}
