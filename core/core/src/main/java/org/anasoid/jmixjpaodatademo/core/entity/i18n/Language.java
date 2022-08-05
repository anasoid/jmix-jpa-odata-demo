package org.anasoid.jmixjpaodatademo.core.entity.i18n;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@JmixEntity
@Table(name = "LANGUAGE")
@Entity
public class Language {

    @NotBlank
    @Column(name = "ID", nullable = false, updatable = false)
    @Id
    private String id;


    @NotBlank
    @Column(name = "NAME", nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @InstanceName

    public String getInstanceName() {
        return getName();
    }
}