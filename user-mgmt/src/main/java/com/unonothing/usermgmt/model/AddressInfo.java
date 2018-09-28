package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.converter.AddressTypeConverter;
import com.unonothing.usermgmt.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

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
@Where(clause = "disabled='false'")
public class AddressInfo extends PersonalInfo {

    @Column(name = "address1", nullable = false)
    @Size(min = 2, max = 255)
    private String address1;

    @Column(name = "address2")
    @Size(max = 255)
    private String address2;

    @Column(name = "address3")
    @Size(max = 255)
    private String address3;

    @Column(name = "city", nullable = false)
    @Size(min = 2, max = 255)
    private String city;

    @Column(name = "state", nullable = false)
    @Size(min = 2, max = 255)
    private String state;

    @Column(name = "country", nullable = false)
    @Size(min = 2, max = 255)
    private String country;

    @Column(name = "zip", nullable = false)
    @Size(min = 2, max = 255)
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
        super(new BaseEntityAudit(new BaseEntity(personalInfo.getDisabled())),
                personalInfo.getPreferred());
    }
}
