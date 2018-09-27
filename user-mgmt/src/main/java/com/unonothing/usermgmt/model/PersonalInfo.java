package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntity;
import com.unonothing.common.model.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class PersonalInfo extends BaseEntityAudit {

    @Column(name = "preferred", nullable = false)
    private Boolean preferred = false;

    public PersonalInfo(BaseEntityAudit baseEntityAudit) {
        super(new BaseEntity(baseEntityAudit.getDeleted()));
    }

    public PersonalInfo(BaseEntityAudit baseEntityAudit, Boolean preferred) {
        this(baseEntityAudit);
        this.preferred = preferred;
    }
}
