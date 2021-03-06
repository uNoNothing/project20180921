package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.EmailInfo;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.stereotype.Repository;

@Repository
@JaversSpringDataAuditable
public interface EmailInfoRepository extends BaseRepository<EmailInfo, Integer> {
}