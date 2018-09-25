package com.unonothing.usermgmt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "name_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class NameInfo extends PersonalInfo {

    private String title;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 1000)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;


    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_nameInfo_userInfo"),
            nullable = false
    )
    private UserInfo userInfo;
}
