package com.unonothing.common.model;

import com.unonothing.common.utils.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

    @Column(name = "created_date", nullable = false)
    private String createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_date")
    private String updateDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    public void setCreateDate(){
        this.createdDate = DateUtils.getCurrentZonedDateTime();
    }

    @PreUpdate
    public void setUpdateDate(){
        this.updateDate = DateUtils.getCurrentZonedDateTime();
    }
}
