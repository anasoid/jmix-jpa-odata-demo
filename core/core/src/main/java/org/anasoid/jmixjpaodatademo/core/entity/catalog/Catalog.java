package org.anasoid.jmixjpaodatademo.core.entity.catalog;

import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.core.entity.AbstractAuditableItem;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@JmixEntity
@Table(name = "CATALOG", indexes = {
        @Index(columnList = "ID", unique = true)
})
@Entity(name = "Catalog")
public class Catalog extends AbstractAuditableItem {


    @NotNull
    @NotBlank()
    @Column(name = "ID", nullable = false)
    private String id;

    @NotNull
    @NotBlank()
    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CatalogVersion> catalogVersions;

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

    public List<CatalogVersion> getCatalogVersions() {
        return catalogVersions;
    }

    public void setCatalogVersions(List<CatalogVersion> catalogVersions) {
        this.catalogVersions = catalogVersions;
    }

    @InstanceName
    @DependsOnProperties({"id", "name"})
    public String getInstanceName() {
        return String.format("%s (%s)", id, getPk());
    }

    @PreUpdate
    @PrePersist
    public void calc() {
        setIntegrationKey(getId());
    }
}