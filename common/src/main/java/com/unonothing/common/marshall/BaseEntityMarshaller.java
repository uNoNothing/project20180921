package com.unonothing.common.marshall;

import com.unonothing.common.dto.BaseEntityDTO;
import com.unonothing.common.model.BaseEntity;

public class BaseEntityMarshaller {

    public static BaseEntityDTO marshall(BaseEntity baseEntity) {

        BaseEntityDTO baseEntityDTO = new BaseEntityDTO();
        if (baseEntity.getId() != null) {
            baseEntityDTO.setId(baseEntity.getId());
        }
        if (baseEntity.getDeleted()) {
            baseEntityDTO.setDeleted(baseEntity.getDeleted());
        }

        return baseEntityDTO;
    }

    public static BaseEntity unmarshall(BaseEntityDTO baseEntityDTO) {

        Boolean deleted;

        if (baseEntityDTO.getDeleted() != null) {
            deleted = baseEntityDTO.getDeleted();
        } else {
            deleted = false;
        }
        BaseEntity baseEntity = new BaseEntity() {
            @Override
            public void setDeleted(Boolean deleted) {
                super.setDeleted(deleted);
            }
        };
        baseEntity.setDeleted(deleted);

        return baseEntity;
    }

}
