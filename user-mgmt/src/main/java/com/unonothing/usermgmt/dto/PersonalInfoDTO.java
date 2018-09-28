package com.unonothing.usermgmt.dto;

import com.unonothing.common.dto.BaseAuditDTO;
import com.unonothing.common.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonalInfoDTO extends BaseAuditDTO {

    @ApiModelProperty(notes = "true if address or email or phone is preferred one")
    private Boolean preferred = true;

    public PersonalInfoDTO(BaseAuditDTO baseEntityAuditDTO) {
        super(new BaseDTO(baseEntityAuditDTO.getId(), baseEntityAuditDTO.getDisabled()));
    }

    public PersonalInfoDTO(BaseAuditDTO baseEntityAuditDTO, Boolean preferred) {
        this(baseEntityAuditDTO);
        this.preferred = preferred;
    }

}
