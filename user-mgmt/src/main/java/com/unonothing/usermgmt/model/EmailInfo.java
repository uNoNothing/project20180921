package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.converter.EmailTypeConverter;
import com.unonothing.usermgmt.enums.EmailType;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "email_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Where(clause = "deleted='false'")
public class EmailInfo extends PersonalInfo {

    @Column(name = "email", nullable = false)
    @Email
    @Size(min = 2, max = 255)
    private String email;

    @Convert(converter = EmailTypeConverter.class)
    @Column(name = "type", nullable = false)
    private EmailType type;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_emailInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;

    public EmailInfo(PersonalInfo personalInfo) {
        super(new BaseEntityAudit(new BaseEntity(personalInfo.getDeleted())),
                personalInfo.getPreferred());
    }
}
