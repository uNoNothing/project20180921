package com.unonothing.usermgmt.model;

import com.unonothing.usermgmt.enums.converter.EmailTypeConverter;
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
import javax.validation.constraints.Email;

@Entity
@Table(name = "email_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmailInfo extends PersonalInfo {

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Convert(converter = EmailTypeConverter.class)
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_emailInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;
}
