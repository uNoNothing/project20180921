package com.unonothing.usermgmt.dto;

import com.unonothing.usermgmt.annotation.ValidEmailType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Email address")
public class EmailInfoDTO extends PersonalInfoDTO {

    @ApiModelProperty(notes = "valid email address")
    @NotEmpty
    @Email
    @Size(min = 2, max = 255)
    private String email;

    @ApiModelProperty(notes = "email type: personal, work or other")
    @NotEmpty
    @ValidEmailType
    @Size(min = 2, max = 255)
    private String type;

    @ApiModelProperty(notes = "userId")
    private Integer userId;

    public EmailInfoDTO(PersonalInfoDTO personalInfoDTO) {
        super(personalInfoDTO, personalInfoDTO.getPreferred());
    }
}
