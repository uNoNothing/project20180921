package com.unonothing.usermgmt.marshall;

import com.unonothing.usermgmt.dto.AddressInfoDTO;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.enums.AddressType;
import com.unonothing.usermgmt.model.AddressInfo;
import com.unonothing.usermgmt.model.PersonalInfo;
import com.unonothing.usermgmt.model.UserInfo;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//Marshaller : We convert java object into DTO.
//Unmarshaller : We convert DTO into java object.
public class AddressInfoMarshaller {


    public static List<AddressInfoDTO> marshall(List<AddressInfo> addressInfoList) {
        List<AddressInfoDTO> addressInfoDTOList = new ArrayList<>();
        for (AddressInfo addressInfo : addressInfoList) {
            addressInfoDTOList.add(marshall(addressInfo));
        }
        return addressInfoDTOList;
    }

    private static AddressInfoDTO marshall(AddressInfo addressInfo) {

        PersonalInfoDTO personalInfoDTO = PersonalInfoMarshaller.marshall(addressInfo);

        AddressInfoDTO addressInfoDTO = new AddressInfoDTO(personalInfoDTO);

        addressInfoDTO.setUserId(addressInfo.getUserInfo().getId());

        if (!StringUtils.isEmpty(addressInfo.getAddress1())) {
            addressInfoDTO.setAddress1(addressInfo.getAddress1());
        }
        if (!StringUtils.isEmpty(addressInfo.getAddress2())) {
            addressInfoDTO.setAddress2(addressInfo.getAddress2());
        }
        if (!StringUtils.isEmpty(addressInfo.getAddress3())) {
            addressInfoDTO.setAddress3(addressInfo.getAddress3());
        }
        if (!StringUtils.isEmpty(addressInfo.getCity())) {
            addressInfoDTO.setCity(addressInfo.getCity());
        }
        if (!StringUtils.isEmpty(addressInfo.getCountry())) {
            addressInfoDTO.setCountry(addressInfo.getCountry());
        }
        if (!StringUtils.isEmpty(addressInfo.getZip())) {
            addressInfoDTO.setZip(addressInfo.getZip());
        }
        if (!StringUtils.isEmpty(addressInfo.getType())) {
            addressInfoDTO.setType(addressInfo.getType().getType());
        }

        return addressInfoDTO;
    }

    public static List<AddressInfo> unmarshall(List<AddressInfoDTO> addressInfoDTOList, UserInfo userInfo) {
        List<AddressInfo> addressInfoList = new ArrayList<>();
        for (AddressInfoDTO addressInfoDTO : addressInfoDTOList) {
            addressInfoList.add(unmarshall(addressInfoDTO, userInfo));
        }
        return addressInfoList;
    }

    private static AddressInfo unmarshall(AddressInfoDTO addressInfoDTO, UserInfo userInfo) {

        if (!StringUtils.isEmpty(userInfo.getCreatedBy())) {
            addressInfoDTO.setCreatedBy(userInfo.getCreatedBy());
        }
        if (!StringUtils.isEmpty(userInfo.getUpdatedBy())) {
            addressInfoDTO.setUpdatedBy(userInfo.getUpdatedBy());
        }
        PersonalInfo personalInfo = PersonalInfoMarshaller.unmarshall(addressInfoDTO);

        AddressInfo addressInfo = new AddressInfo(personalInfo);

        addressInfo.setUserInfo(userInfo);

        addressInfo.setAddress1(addressInfoDTO.getAddress1());
        addressInfo.setAddress2(addressInfoDTO.getAddress2());
        addressInfo.setAddress3(addressInfoDTO.getAddress3());
        addressInfo.setCity(addressInfoDTO.getCity());
        addressInfo.setState(addressInfoDTO.getState());
        addressInfo.setCountry(addressInfoDTO.getCountry());
        addressInfo.setZip(addressInfoDTO.getZip());
        addressInfo.setType(AddressType.getEnum(addressInfoDTO.getType()));

        return addressInfo;

    }

}
