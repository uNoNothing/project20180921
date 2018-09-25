package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.PhoneInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneInfoRepository extends BaseRepository<PhoneInfo, Integer> {
}