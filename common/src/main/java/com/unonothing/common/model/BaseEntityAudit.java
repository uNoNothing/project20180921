package com.unonothing.common.model;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
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
import javax.persistence.Transient;

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

    @Transient
    private String currentUser;

    public BaseEntityAudit(BaseEntity baseEntity) {
        super(baseEntity.getDeleted());
    }

    public BaseEntityAudit(BaseEntity baseEntity,
                           String currentUser){
        this(baseEntity);
        if (!StringUtils.isEmpty(currentUser)){
            this.currentUser = currentUser;
        } else {
            throw ExceptionFactory.create(ExceptionType.INTERNAL_SERVER_ERROR,
                    "currentUser is null or empty");
        }

    }

    @PrePersist
    public void setCreate() {
        this.createdDate = DateUtils.getCurrentZonedDateTime();
        this.createdBy = currentUser;
    }

    @PreUpdate
    public void setUpdate() {
        this.updateDate = DateUtils.getCurrentZonedDateTime();
        this.updatedBy = currentUser;
    }
}
