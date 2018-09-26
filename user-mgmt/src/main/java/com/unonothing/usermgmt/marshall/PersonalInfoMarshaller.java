package com.unonothing.usermgmt.marshall;

import com.unonothing.common.dto.BaseEntityAuditDTO;
import com.unonothing.common.marshall.BaseEntityAuditMarshaller;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.model.PersonalInfo;

public class PersonalInfoMarshaller {

    public static PersonalInfoDTO marshall(PersonalInfo personalInfo){

        BaseEntityAuditDTO baseEntityAuditDTO = BaseEntityAuditMarshaller.marshall(personalInfo);

        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO(baseEntityAuditDTO, personalInfo.getPreferred());

        return personalInfoDTO;
    }

    public static PersonalInfo unmarshall(PersonalInfoDTO personalInfoDTO, String currentUser){

        BaseEntityAudit baseEntityAudit = BaseEntityAuditMarshaller.unmarshall(personalInfoDTO, currentUser);

        PersonalInfo personalInfo = new PersonalInfo(baseEntityAudit, personalInfoDTO.getPreferred());

        return personalInfo;
    }
}
