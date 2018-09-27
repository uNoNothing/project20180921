package com.unonothing.common.marshall;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.model.BaseEntity;

public class BaseEntityMarshaller {

    public static BaseDTO marshall(BaseEntity baseEntity) {

        BaseDTO baseDTO = new BaseDTO();
        if (baseEntity.getId() != null) {
            baseDTO.setId(baseEntity.getId());
        }
        if (baseEntity.getDeleted()) {
            baseDTO.setDeleted(baseEntity.getDeleted());
        }

        return baseDTO;
    }

    public static BaseEntity unmarshall(BaseDTO baseDTO) {

        Boolean deleted;

        if (baseDTO.getDeleted() != null) {
            deleted = baseDTO.getDeleted();
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
