package com.unonothing.usermgmt.model;

import com.unonothing.common.enums.PhoneTypeConverter;
import com.unonothing.usermgmt.model.PersonalInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_info")
@Getter
@Setter
@NoArgsConstructor
public class PhoneInfo extends PersonalInfo {

    @Column(name = "phone")
    private String phone;

    @Convert(converter = PhoneTypeConverter.class)
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_phoneInfo_user"),
            nullable = false
    )
    private User user;
}
