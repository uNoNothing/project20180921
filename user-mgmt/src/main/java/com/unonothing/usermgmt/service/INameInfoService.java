package com.unonothing.usermgmt.service;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.usermgmt.dto.NameInfoDTO;

import java.util.List;

public interface INameInfoService {

    void update(NameInfoDTO nameInfoDTO);

    List<NameInfoDTO> read(BaseDTO baseDTO);
}
