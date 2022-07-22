package org.anasoid.jmixjpaodatademo.core.entity.catalog;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.core.entity.AbstractAuditableItem;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JmixEntity
@Table(name = "CATALOG_VERSION", indexes = {
        @Index(columnList = "CATALOG, VERSION", unique = true)
})
@Entity
public class CatalogVersion extends AbstractAuditableItem {


    @JoinColumn(name = "CATALOG", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Catalog catalog;

    @Column(name = "VERSION", nullable = false, length = 50)
    @NotBlank()
    @NotNull
    private String version;


    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @InstanceName
    @DependsOnProperties({"catalog", "version"})
    public String getInstanceName() {
        return String.format("%s %s", catalog.getId(), version);
    }

    @PreUpdate
    @PrePersist
    public void calc() {
        setIntegrationKey(getVersion() + "|"+getCatalog().getId());
    }
}