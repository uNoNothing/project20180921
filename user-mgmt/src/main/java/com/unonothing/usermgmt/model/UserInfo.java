package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "userInfo",
        uniqueConstraints = @UniqueConstraint(name = "UK_userName", columnNames = {"userName"}))
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfo extends BaseEntityAudit {

    @Column(name = "username", updatable = false)
    @Size(min = 8)
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo", fetch = FetchType.LAZY)
    private List<NameInfo> nameInfoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo", fetch = FetchType.LAZY)
    private List<AddressInfo> AddressInfoList;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo", fetch = FetchType.LAZY)
//    private List<SesameInfo> sesameInfoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo", fetch = FetchType.LAZY)
    private List<EmailInfo> emailInfoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo", fetch = FetchType.LAZY)
    private List<PhoneInfo> phoneInfoList;


    public UserInfo(BaseEntityAudit baseEntityAudit) {
        super(new BaseEntity(baseEntityAudit.getDeleted()),
                baseEntityAudit.getCreatedBy(), baseEntityAudit.getUpdatedBy());
    }

    public UserInfo(BaseEntityAudit baseEntityAudit, String userName) {
        this(baseEntityAudit);
        this.userName = userName;
    }

}
