package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.NameInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface NameInfoRepository extends BaseRepository<NameInfo, Integer> {
}