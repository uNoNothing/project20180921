package com.unonothing.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseAuditDTO extends BaseDTO {

    @ApiModelProperty(notes = "created date, system generated")
    private String createdDate;

    @ApiModelProperty(notes = "created by, set by system")
    private String createdBy;

    @ApiModelProperty(notes = "updated date, system generated")
    private String updatedDate;

    @ApiModelProperty(notes = "updated by, set by system")
    private String updatedBy;

    public BaseAuditDTO(BaseDTO baseDTO) {
        super(baseDTO.getId(), baseDTO.getDisabled());
    }
}
