package com.unonothing.usermgmt.dto;

import com.unonothing.common.dto.BaseEntityAuditDTO;
import com.unonothing.common.dto.BaseEntityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "User info")
public class UserInfoDTO extends BaseEntityAuditDTO {

    @ApiModelProperty(notes = "userName should have at least 8 characters")
    @NotEmpty
    @Size(min = 8, message = "userName should have at least 8 characters")
    private String userName;

//    @ApiModelProperty(notes = "name info list")
    //    @NotEmpty
//    private List<NameInfoDTO> nameList;

    @ApiModelProperty(notes = "address list")
    //    @NotEmpty
    private List<AddressInfoDTO> addressList;

//    @ApiModelProperty(notes = "email address list")
    //    @NotEmpty
//    private List<EmailInfoDTO> emailList;

//    @ApiModelProperty(notes = "phone number list")
    //    @NotEmpty
//    private List<PhoneInfoDTO> phoneList;

    public UserInfoDTO(BaseEntityAuditDTO baseEntityAuditDTO) {
        super(new BaseEntityDTO(baseEntityAuditDTO.getId(), baseEntityAuditDTO.getDeleted()),
                baseEntityAuditDTO.getCreatedDate(), baseEntityAuditDTO.getCreatedBy(),
                baseEntityAuditDTO.getUpdatedDate(), baseEntityAuditDTO.getUpdatedBy());
    }

    public UserInfoDTO(BaseEntityAuditDTO baseEntityAuditDTO, String userName) {
        this(baseEntityAuditDTO);
        this.userName = userName;
    }
}
