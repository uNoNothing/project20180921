package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.NameInfo;
import com.unonothing.usermgmt.model.UserInfo;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JaversSpringDataAuditable
public interface NameInfoRepository extends BaseRepository<NameInfo, Integer> {

    List<NameInfo> findByUserInfo(UserInfo userInfo);
}