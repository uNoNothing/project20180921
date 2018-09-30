package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.PhoneInfo;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.stereotype.Repository;

@Repository
@JaversSpringDataAuditable
public interface PhoneInfoRepository extends BaseRepository<PhoneInfo, Integer> {
}