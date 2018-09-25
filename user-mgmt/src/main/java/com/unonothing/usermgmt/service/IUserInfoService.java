package com.unonothing.usermgmt.service;

import com.unonothing.usermgmt.dto.UserInfoDTO;

import java.util.List;

public interface IUserInfoService {
    void create(UserInfoDTO userInfoDTO);

    List<UserInfoDTO> read();

//    UserInfoDTO read(Integer id);

//    void update(UserInfoDTO userInfoDTO);

//    void delete(Integer id);
}
