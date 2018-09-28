package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.enums.PhoneType;
import com.unonothing.usermgmt.converter.PhoneTypeConverter;
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
@Table(name = "phone_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Where(clause = "disabled='false'")
public class PhoneInfo extends PersonalInfo {

    @Column(name = "phone")
    @Size(min = 3, max = 255)
    private String phone;

    @Convert(converter = PhoneTypeConverter.class)
    @Column(name = "type", nullable = false)
    private PhoneType type;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_phoneInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;

    public PhoneInfo(PersonalInfo personalInfo) {
        super(new BaseEntityAudit(new BaseEntity(personalInfo.getDisabled())),
                personalInfo.getPreferred());
    }
}
