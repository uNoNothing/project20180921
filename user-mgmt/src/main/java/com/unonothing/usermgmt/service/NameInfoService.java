package com.unonothing.usermgmt.service;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.common.utils.CompareDTOs;
import com.unonothing.usermgmt.dto.NameInfoDTO;
import com.unonothing.usermgmt.marshall.NameInfoMarshaller;
import com.unonothing.usermgmt.model.NameInfo;
import com.unonothing.usermgmt.model.UserInfo;
import com.unonothing.usermgmt.repository.NameInfoRepository;
import com.unonothing.usermgmt.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("name service")
public class NameInfoService implements INameInfoService {

    private static final Logger log = LoggerFactory.getLogger(NameInfoService.class);

    @Autowired
    private NameInfoRepository nameInfoRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional
    @Override
    public void update(NameInfoDTO nameInfoDTO) {
        if (nameInfoDTO.getId() != null) {
            Optional<NameInfo> nameInfo = nameInfoRepository.findById(nameInfoDTO.getId());

            if (nameInfo.isPresent()) {

                // check if there is higher version of nameInfo
                higherVersionPresent(nameInfo.get());

                NameInfoDTO nameInfoDTOFromDb = NameInfoMarshaller.marshall(nameInfo.get());
                // check if there are any updates
                ArrayList<String> changedParameterList = CompareDTOs.compare(nameInfoDTO, nameInfoDTOFromDb);

                if (!CollectionUtils.isEmpty(changedParameterList)) {

                    if (log.isTraceEnabled()) {
                        log.trace("changed parameters: ");
                        changedParameterList.forEach(s -> log.trace(s));
                    }

                    NameInfoDTO nameInfoDTOToDb = new NameInfoDTO();
                    BeanUtils.copyProperties(nameInfoDTOFromDb, nameInfoDTOToDb);

                    for (String parameter : changedParameterList) {
                        PropertyAccessor nameInfoDTOToDbPropertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(nameInfoDTOToDb);
                        PropertyAccessor nameInfoDTOPropertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(nameInfoDTO);

                        nameInfoDTOToDbPropertyAccessor.setPropertyValue(parameter, nameInfoDTOPropertyAccessor.getPropertyValue(parameter));
                    }

                    // don't update current row
                    // instead create a new row and increase version number
                    nameInfoDTOToDb.setVersion(nameInfoDTOFromDb.getVersion() + 1);
                    log.info("before save: " + NameInfoMarshaller.unmarshall(nameInfoDTOToDb, nameInfo.get().getUserInfo()));

                    nameInfoRepository.save(NameInfoMarshaller.unmarshall(nameInfoDTOToDb, nameInfo.get().getUserInfo()));

                    // update preferred field in old version
                    nameInfo.get().setPreferred(false);
                    nameInfoRepository.save(nameInfo.get());
                } else {
                    throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "No change detected", "nameInfo");
                }
            } else {
                throw ExceptionFactory.create(ExceptionType.NO_CONTENT, "Can not find name info");
            }
        } else {
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "id", "null");
        }

    }

    private void higherVersionPresent(NameInfo nameInfo) {

        Integer currentVersion = nameInfo.getVersion();

        // get all nameInfos
        List<NameInfoDTO> nameInfoDTOList = read(new BaseDTO(nameInfo.getUserInfo().getId(), false));

        Optional<Integer> highestVersion = nameInfoDTOList
                .stream()
                .map(nameInfoDTO -> nameInfoDTO.getVersion())
                .max(Integer::compareTo);

        if (highestVersion.isPresent()) {
            if (currentVersion.intValue() != highestVersion.get().intValue()) {
                throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "Can not update lower version", currentVersion.toString());
            }
        } else {
            throw ExceptionFactory.create(ExceptionType.INTERNAL_SERVER_ERROR, "name info version error");
        }


    }

    @Override
    public List<NameInfoDTO> read(BaseDTO baseDTO) {

        Optional<UserInfo> userInfo = userInfoRepository.findById(baseDTO.getId());

        if (userInfo.isPresent()) {
            List<NameInfo> nameInfoList = nameInfoRepository.findByUserInfo(userInfo.get());

            if (!CollectionUtils.isEmpty(nameInfoList)) {
                return NameInfoMarshaller.marshall(nameInfoList);
            } else {
                throw ExceptionFactory.create(ExceptionType.NO_CONTENT, "name info list not found");
            }
        } else {
            throw ExceptionFactory.create(ExceptionType.NO_CONTENT, "user info not found");
        }
    }
}
