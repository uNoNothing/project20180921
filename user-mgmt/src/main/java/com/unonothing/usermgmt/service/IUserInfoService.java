package com.unonothing.usermgmt.service;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.usermgmt.dto.UserInfoDTO;

import java.util.List;

public interface IUserInfoService {
    void create(UserInfoDTO userInfoDTO);

    List<UserInfoDTO> read();

    UserInfoDTO read(BaseDTO baseDTO);

//    void update(UserInfoDTO userInfoDTO);

    void disable(BaseDTO baseDTO);

    void delete(BaseDTO baseDTO);
}
