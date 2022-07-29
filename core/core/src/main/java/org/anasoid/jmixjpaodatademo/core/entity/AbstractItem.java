package org.anasoid.jmixjpaodatademo.core.entity;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;


import javax.persistence.*;


@JmixEntity
@MappedSuperclass
public abstract class AbstractItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK", nullable = false)
    @Id
    @EdmIgnore
    private Long pk;

    @Column(name = "integrationKey", nullable = true)
    private String integrationKey;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getIntegrationKey() {
        return integrationKey;
    }

    public void setIntegrationKey(String integrationKey) {
        this.integrationKey = integrationKey;
    }
}