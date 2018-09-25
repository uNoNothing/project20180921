package com.unonothing.usermgmt.dto;

import com.unonothing.usermgmt.enums.validator.ValidAddressType;
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
    @Size(min = 2, message = "address1 should have at least 2 characters")
    @NotEmpty
    private String address1;

    @ApiModelProperty(notes = "address2 is optional")
    private String address2;

    @ApiModelProperty(notes = "address3 is optional")
    private String address3;

    @ApiModelProperty(notes = "city should have at least 2 characters")
    @Size(min = 2, message = "city should have at least 2 characters")
    @NotEmpty
    private String city;

    @ApiModelProperty(notes = "state should have at least 2 characters")
    @Size(min = 2, message = "state should have at least 2 characters")
    @NotEmpty
    private String state;

    @ApiModelProperty(notes = "country should have at least 2 characters")
    @Size(min = 2, message = "country should have at least 2 characters")
    @NotEmpty
    private String country;

    @ApiModelProperty(notes = "zip should have at least 2 characters")
    @Size(min = 2, message = "zip should have at least 2 characters")
    @NotEmpty
    private String zip;

    @ApiModelProperty(notes = "address type: home, work or other")
    @NotEmpty
    @ValidAddressType
    private String type;

    @ApiModelProperty(notes = "userId")
    private Integer userId;

    public AddressInfoDTO(PersonalInfoDTO personalInfoDTO) {
        super(personalInfoDTO, personalInfoDTO.getPreferred());
    }

}
