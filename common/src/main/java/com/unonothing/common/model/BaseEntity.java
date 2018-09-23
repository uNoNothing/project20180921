package com.unonothing.common.model;

import com.unonothing.common.utils.Uuid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, onlyExplicitlyIncluded = true)
@MappedSuperclass
@Where(clause = "deleted = false")
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    protected Integer id;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "uuid", nullable = false)
    private String uuid = Uuid.generate();

}
