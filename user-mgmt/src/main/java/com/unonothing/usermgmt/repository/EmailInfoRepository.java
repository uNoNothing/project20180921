package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.EmailInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailInfoRepository extends BaseRepository<EmailInfo, Integer> {
}