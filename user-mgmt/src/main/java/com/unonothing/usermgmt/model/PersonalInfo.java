package com.unonothing.usermgmt.model;

import com.unonothing.common.model.BaseEntityAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PersonalInfo extends BaseEntityAudit {

    @Column(name = "preferred", nullable = false)
    private Boolean preferred = false;
}
