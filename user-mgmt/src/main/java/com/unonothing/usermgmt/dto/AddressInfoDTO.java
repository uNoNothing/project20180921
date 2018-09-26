package com.unonothing.usermgmt.dto;

import com.unonothing.usermgmt.annotation.ValidAddressType;
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
@ApiModel(description = "Address")
public class AddressInfoDTO extends PersonalInfoDTO {

    @ApiModelProperty(notes = "address1 should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "address1 length between 2 and 255")
    private String address1;

    @ApiModelProperty(notes = "address2 is optional")
    @Size(max = 5, message = "address2 max length 255")
    private String address2;

    @ApiModelProperty(notes = "address3 is optional")
    @Size(max = 255, message = "address23 max length 255")
    private String address3;

    @ApiModelProperty(notes = "city should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "city should have at least 2 characters")
    private String city;

    @ApiModelProperty(notes = "state should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "state should have at least 2 characters")
    private String state;

    @ApiModelProperty(notes = "country should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "country should have at least 2 characters")
    private String country;

    @ApiModelProperty(notes = "zip should have at least 2 characters")
    @NotEmpty
    @Size(min = 2, max = 255, message = "zip should have at least 2 characters")
    private String zip;

    @ApiModelProperty(notes = "address type: home, work or other")
    @NotEmpty
    @ValidAddressType
    @Size(min = 2, max = 255)
    private String type;

    @ApiModelProperty(notes = "userId")
    private Integer userId;

    public AddressInfoDTO(PersonalInfoDTO personalInfoDTO) {
        super(personalInfoDTO, personalInfoDTO.getPreferred());
    }

}
