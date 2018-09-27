package com.unonothing.usermgmt.marshall;

import com.unonothing.common.dto.BaseAuditDTO;
import com.unonothing.common.marshall.BaseEntityAuditMarshaller;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.dto.PersonalInfoDTO;
import com.unonothing.usermgmt.model.PersonalInfo;

public class PersonalInfoMarshaller {

    public static PersonalInfoDTO marshall(PersonalInfo personalInfo){

        BaseAuditDTO baseEntityAuditDTO = BaseEntityAuditMarshaller.marshall(personalInfo);

        PersonalInfoDTO personalInfoDTO = new PersonalInfoDTO(baseEntityAuditDTO, personalInfo.getPreferred());

        return personalInfoDTO;
    }

    public static PersonalInfo unmarshall(PersonalInfoDTO personalInfoDTO){

        BaseEntityAudit baseEntityAudit = BaseEntityAuditMarshaller.unmarshall(personalInfoDTO);

        PersonalInfo personalInfo = new PersonalInfo(baseEntityAudit, personalInfoDTO.getPreferred());

        return personalInfo;
    }
}
