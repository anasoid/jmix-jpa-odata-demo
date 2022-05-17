package org.anasoid.jmixjpaodatademo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;


@JmixEntity
@MappedSuperclass
public abstract class AbstractItem {
    @JmixGeneratedValue()
    @Column(name = "PK", nullable = false)
    @Id
    private Long pk;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}