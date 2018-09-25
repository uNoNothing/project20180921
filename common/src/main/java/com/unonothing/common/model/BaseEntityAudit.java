package com.unonothing.common.model;

import com.unonothing.common.utils.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@ToString
public class BaseEntityAudit extends BaseEntity {

    @Column(name = "created_date", nullable = false)
    private String createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_date")
    private String updateDate;
    @Column(name = "updated_by")
    private String updatedBy;

    public BaseEntityAudit(BaseEntity baseEntity) {
        super(baseEntity.getDeleted());
    }

    public BaseEntityAudit(BaseEntity baseEntity,
                           String createdBy, String updatedBy){
        this(baseEntity);
        if (!StringUtils.isEmpty(createdBy)){
            this.createdBy = createdBy;
        }
        if (!StringUtils.isEmpty(updatedBy)){
            this.updatedBy = updatedBy;
        }
    }

    @PrePersist
    public void setCreateDate() {
        this.createdDate = DateUtils.getCurrentZonedDateTime();
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updateDate = DateUtils.getCurrentZonedDateTime();
    }
}
