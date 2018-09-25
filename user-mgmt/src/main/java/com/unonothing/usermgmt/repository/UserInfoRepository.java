package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends BaseRepository<UserInfo, Integer> {
}