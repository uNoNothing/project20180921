package com.unonothing.usermgmt.service;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.UserInfoDTO;
import com.unonothing.usermgmt.marshall.UserInfoMarshaller;
import com.unonothing.usermgmt.model.AddressInfo;
import com.unonothing.usermgmt.model.EmailInfo;
import com.unonothing.usermgmt.model.NameInfo;
import com.unonothing.usermgmt.model.PhoneInfo;
import com.unonothing.usermgmt.model.UserInfo;
import com.unonothing.usermgmt.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userInfoService")
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional
    public void create(UserInfoDTO userInfoDTO) {

        UserInfo userInfo = UserInfoMarshaller.unmarshall(userInfoDTO);

        userInfoRepository.save(userInfo);
    }

    @Override
    public List<UserInfoDTO> read() {
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();

        List<UserInfo> userInfoList = userInfoRepository.findAll();

        if (!CollectionUtils.isEmpty(userInfoList)) {
            userInfoDTOList.addAll(UserInfoMarshaller.marshall(userInfoList));
        } else {
            throw ExceptionFactory.create(ExceptionType.NO_CONTENT);
        }

        return userInfoDTOList;

    }

    @Override
    public void delete(BaseDTO baseDTO) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(baseDTO.getId());

        if (userInfo.isPresent()) {
            UserInfo userInfo1 = userInfo.get();

            // soft delete
            userInfo1.setDeleted(true);

            List<NameInfo> nameInfoList = userInfo1.getNameInfoList();
            if (!CollectionUtils.isEmpty(nameInfoList)) {
                nameInfoList.forEach(nameInfo -> nameInfo.setDeleted(true));
            }

            List<AddressInfo> addressInfoList = userInfo1.getAddressInfoList();
            if (!CollectionUtils.isEmpty(addressInfoList)) {
                addressInfoList.forEach(addressInfo -> addressInfo.setDeleted(true));
            }

            List<EmailInfo> emailInfoList = userInfo1.getEmailInfoList();
            if (!CollectionUtils.isEmpty(emailInfoList)) {
                emailInfoList.forEach(emailInfo -> emailInfo.setDeleted(true));
            }

            List<PhoneInfo> phoneInfoList = userInfo1.getPhoneInfoList();
            if (!CollectionUtils.isEmpty(phoneInfoList)) {
                phoneInfoList.forEach(phoneInfo -> phoneInfo.setDeleted(true));
            }

            userInfoRepository.save(userInfo1);

        } else {
            throw ExceptionFactory.create(ExceptionType.NO_CONTENT);
        }
    }

    @Override
    public UserInfoDTO read(BaseDTO baseDTO) {
        UserInfoDTO userInfoDTO;
        Optional<UserInfo> userInfo = userInfoRepository.findById(baseDTO.getId());

        if (userInfo.isPresent()) {
            userInfoDTO = UserInfoMarshaller.marshall(userInfo.get());
        } else {
            throw ExceptionFactory.create(ExceptionType.NO_CONTENT);
        }

        return userInfoDTO;
    }


}
