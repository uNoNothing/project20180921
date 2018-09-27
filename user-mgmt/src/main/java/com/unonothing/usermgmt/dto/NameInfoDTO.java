package com.unonothing.usermgmt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Name info")
public class NameInfoDTO extends PersonalInfoDTO {

    @ApiModelProperty(notes = "title is optional")
    @Size(max = 255)
    private String title;

    @ApiModelProperty(notes = "firstName should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "firstName should have at least 2 characters")
    private String firstName;

    @ApiModelProperty(notes = "middleName is optional")
    @Size(max = 255)
    private String middleName;

    @ApiModelProperty(notes = "lastName should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "lastName should have at least 2 characters")
    private String lastName;

    @ApiModelProperty(notes = "userId")
    private Integer userId;

    public NameInfoDTO(PersonalInfoDTO personalInfoDTO) {
        super(personalInfoDTO, personalInfoDTO.getPreferred());
    }
}
