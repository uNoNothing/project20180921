package com.unonothing.common.marshall;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.model.BaseEntity;

public class BaseEntityMarshaller {

    public static BaseDTO marshall(BaseEntity baseEntity) {

        BaseDTO baseDTO = new BaseDTO();
        if (baseEntity.getId() != null) {
            baseDTO.setId(baseEntity.getId());
        }
        if (baseEntity.getDisabled()) {
            baseDTO.setDisabled(baseEntity.getDisabled());
        }

        return baseDTO;
    }

    public static BaseEntity unmarshall(BaseDTO baseDTO) {

        Boolean deleted;

        if (baseDTO.getDisabled() != null) {
            deleted = baseDTO.getDisabled();
        } else {
            deleted = false;
        }
        BaseEntity baseEntity = new BaseEntity() {
            @Override
            public void setDisabled(Boolean disabled) {
                super.setDisabled(disabled);
            }
        };
        baseEntity.setDisabled(deleted);

        return baseEntity;
    }

}
