package com.unonothing.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseEntityAuditDTO extends BaseEntityDTO {

    @ApiModelProperty(notes = "created date, system generated")
    private String createdDate;

    @ApiModelProperty(notes = "created by, set by system")
    private String createdBy;

    @ApiModelProperty(notes = "updated date, system generated")
    private String updatedDate;

    @ApiModelProperty(notes = "updated by, set by system")
    private String updatedBy;

    public BaseEntityAuditDTO(BaseEntityDTO baseEntityDTO) {
        super(baseEntityDTO.getId(), baseEntityDTO.getDeleted());
    }

    public BaseEntityAuditDTO(BaseEntityDTO baseEntityDTO,
                              String createdDate, String createdBy,
                              String updatedDate, String updatedBy) {
        this(baseEntityDTO);
        this.createdDate = createdDate;
        this.createdBy = createdBy;

        if (!StringUtils.isEmpty(updatedDate) && !StringUtils.isEmpty(updatedBy)) {
            this.updatedDate = updatedDate;
            this.updatedBy = updatedBy;
        }
    }

}
