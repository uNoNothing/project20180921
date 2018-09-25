package com.unonothing.usermgmt.dto;

import com.unonothing.common.dto.BaseEntityAuditDTO;
import com.unonothing.common.dto.BaseEntityDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonalInfoDTO extends BaseEntityAuditDTO {

    @ApiModelProperty(notes = "true if address or email or phone is preferred one")
    private Boolean preferred = false;

    public PersonalInfoDTO(BaseEntityAuditDTO baseEntityAuditDTO) {
        super(new BaseEntityDTO(baseEntityAuditDTO.getId(), baseEntityAuditDTO.getDeleted()),
                baseEntityAuditDTO.getCreatedDate(), baseEntityAuditDTO.getCreatedBy(),
                baseEntityAuditDTO.getUpdatedDate(), baseEntityAuditDTO.getUpdatedBy());
    }

    public PersonalInfoDTO(BaseEntityAuditDTO baseEntityAuditDTO, Boolean preferred) {
        this(baseEntityAuditDTO);
        this.preferred = preferred;
    }

}
