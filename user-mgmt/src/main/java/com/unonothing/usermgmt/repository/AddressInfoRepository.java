package com.unonothing.usermgmt.repository;

import com.unonothing.common.repository.BaseRepository;
import com.unonothing.usermgmt.model.AddressInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInfoRepository extends BaseRepository<AddressInfo, Integer> {
}