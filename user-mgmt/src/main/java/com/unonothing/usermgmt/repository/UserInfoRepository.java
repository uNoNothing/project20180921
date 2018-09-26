package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends BaseRepository<UserInfo, Integer> {

    @Query("SELECT " +
            "CASE WHEN COUNT(u)>0 " +
            "THEN true " +
            "ELSE false END " +
            "FROM UserInfo u " +
            "WHERE u.userName = :userName")
    boolean userNameExists(@Param("userName") String userName);
}