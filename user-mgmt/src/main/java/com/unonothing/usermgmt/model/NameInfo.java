package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "name_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Where(clause = "disabled='false'")
public class NameInfo extends PersonalInfo {

    @Size(max = 255)
    private String title;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 255)
    private String firstName;

    @Column(name = "middle_name")
    @Size(min = 2, max = 255)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 255)
    private String lastName;


    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_nameInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;

    public NameInfo(PersonalInfo personalInfo) {
        super(new BaseEntityAudit(new BaseEntity(personalInfo.getDisabled())),
                personalInfo.getPreferred());
    }
}
