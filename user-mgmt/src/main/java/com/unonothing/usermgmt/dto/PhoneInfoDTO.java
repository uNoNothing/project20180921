package com.unonothing.usermgmt.dto;

import com.unonothing.usermgmt.enums.validator.ValidPhoneType;
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
@ApiModel(description = "Phone Number")
public class PhoneInfoDTO extends PersonalInfoDTO {

    @ApiModelProperty(notes = "phone should have at least 3 characters")
    @NotEmpty
    @Size(min = 3, message = "phone should have at least 3 characters")
    private String phone;

    @ApiModelProperty(notes = "address type: mobile, home, work, home fax, work or other")
    @NotEmpty
    @ValidPhoneType
    private String type;

    @ApiModelProperty(notes = "userId")
    private Integer userId;
}
