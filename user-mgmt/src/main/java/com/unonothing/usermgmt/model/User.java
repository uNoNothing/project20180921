package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntityAudit;
import com.unonothing.usermgmt.model.EmailInfo;
import com.unonothing.usermgmt.model.NameInfo;
import com.unonothing.usermgmt.model.PhoneInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntityAudit {

    @Column(name = "username", updatable = false, unique = true)
    @Size(min = 8)
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<NameInfo> nameInfoList;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//    private List<SesameInfo> sesameInfoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<EmailInfo> emailInfoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<PhoneInfo> phoneInfoList;




}
