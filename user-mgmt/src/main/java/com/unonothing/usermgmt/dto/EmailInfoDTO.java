package com.unonothing.usermgmt.dto;

import com.unonothing.usermgmt.enums.validator.ValidEmailType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Email address")
public class EmailInfoDTO extends PersonalInfoDTO {

    @ApiModelProperty(notes = "valid email address")
    @NotEmpty
    @Email
    private String email;

    @ApiModelProperty(notes = "email type: personal, work or other")
    @NotEmpty
    @ValidEmailType
    private String type;

    @ApiModelProperty(notes = "userId")
    private Integer userId;
}
