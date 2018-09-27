package com.unonothing.usermgmt.dto;

import com.unonothing.common.dto.BaseAuditDTO;
import com.unonothing.common.dto.BaseDTO;
import com.unonothing.usermgmt.annotation.ValidUserName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "User info")
public class UserInfoDTO extends BaseAuditDTO {

    @ApiModelProperty(notes = "userName should have at least 4 characters")
    @NotEmpty
    @Size(min = 4, max = 255)
    @ValidUserName
    private String userName;

    @ApiModelProperty(notes = "name info list")
    @NotEmpty
    @Valid
    private List<NameInfoDTO> nameList;

    @ApiModelProperty(notes = "address list")
    @Valid
    private List<AddressInfoDTO> addressList;

    @ApiModelProperty(notes = "email address list")
    @Valid
    private List<EmailInfoDTO> emailList;

    @ApiModelProperty(notes = "phone number list")
    @Valid
    private List<PhoneInfoDTO> phoneList;

    public UserInfoDTO(BaseAuditDTO baseEntityAuditDTO) {
        super(new BaseDTO(baseEntityAuditDTO.getId(), baseEntityAuditDTO.getDeleted()));
    }

    public UserInfoDTO(BaseAuditDTO baseEntityAuditDTO, String userName) {
        this(baseEntityAuditDTO);
        this.userName = userName;
    }
}
