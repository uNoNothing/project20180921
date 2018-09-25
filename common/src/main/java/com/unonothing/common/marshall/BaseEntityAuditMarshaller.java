package com.unonothing.common.marshall;

import com.unonothing.common.dto.BaseEntityAuditDTO;
import com.unonothing.common.dto.BaseEntityDTO;
import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;

public class BaseEntityAuditMarshaller {

    public static BaseEntityAuditDTO marshall(BaseEntityAudit baseEntityAudit) {

        BaseEntityDTO baseEntityDTO = BaseEntityMarshaller.marshall(baseEntityAudit);

        BaseEntityAuditDTO baseEntityAuditDTO = new BaseEntityAuditDTO(baseEntityDTO);
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

    public static BaseEntityAudit unmarshall(BaseEntityAuditDTO baseEntityAuditDTO) {

        BaseEntity baseEntity = BaseEntityMarshaller.unmarshall(baseEntityAuditDTO);

        BaseEntityAudit baseEntityAudit = new BaseEntityAudit(baseEntity);
        if (baseEntityAuditDTO.getCreatedBy() != null) {
            baseEntityAudit.setCreatedBy(baseEntityAuditDTO.getCreatedBy());
        }
        if (baseEntityAuditDTO.getUpdatedBy() != null) {
            baseEntityAudit.setUpdatedBy(baseEntityAuditDTO.getUpdatedBy());
        }

        return baseEntityAudit;

    }
}
