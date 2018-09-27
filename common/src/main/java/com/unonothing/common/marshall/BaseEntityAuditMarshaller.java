package com.unonothing.common.marshall;

import com.unonothing.common.dto.BaseAuditDTO;
import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;

public class BaseEntityAuditMarshaller {

    public static BaseAuditDTO marshall(BaseEntityAudit baseEntityAudit) {

        BaseDTO baseDTO = BaseEntityMarshaller.marshall(baseEntityAudit);

        BaseAuditDTO baseEntityAuditDTO = new BaseAuditDTO(baseDTO);
        if (baseEntityAudit.getCreatedBy() != null) {
            baseEntityAuditDTO.setCreatedBy(baseEntityAudit.getCreatedBy());
        }
        if (baseEntityAudit.getCreatedDate() != null) {
            baseEntityAuditDTO.setCreatedDate(baseEntityAudit.getCreatedDate());
        }
        if (baseEntityAudit.getUpdatedBy() != null) {
            baseEntityAuditDTO.setUpdatedBy(baseEntityAudit.getUpdatedBy());
        }
        if (baseEntityAudit.getUpdateDate() != null) {
            baseEntityAuditDTO.setUpdatedDate(baseEntityAudit.getUpdateDate());
        }

        return baseEntityAuditDTO;
    }

    public static BaseEntityAudit unmarshall(BaseAuditDTO baseEntityAuditDTO) {

        BaseEntity baseEntity = BaseEntityMarshaller.unmarshall(baseEntityAuditDTO);

        BaseEntityAudit baseEntityAudit = new BaseEntityAudit(baseEntity);

        return baseEntityAudit;

    }
}
