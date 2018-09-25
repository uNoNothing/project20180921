package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.enums.AddressType;
import com.unonothing.usermgmt.enums.converter.AddressTypeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressInfo extends PersonalInfo {

    @Column(name = "address1", nullable = false)
    @Size(min = 2)
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "city", nullable = false)
    @Size(min = 2)
    private String city;

    @Column(name = "state", nullable = false)
    @Size(min = 2)
    private String state;

    @Column(name = "country", nullable = false)
    @Size(min = 2)
    private String country;

    @Column(name = "zip", nullable = false)
    @Size(min = 2)
    private String zip;

    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "type", nullable = false)
    private AddressType type;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_addressInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;

    public AddressInfo(PersonalInfo personalInfo) {
        super(new BaseEntityAudit(new BaseEntity(personalInfo.getDeleted()),
                        personalInfo.getCreatedBy(), personalInfo.getUpdatedBy()),
                personalInfo.getPreferred());
    }
}
