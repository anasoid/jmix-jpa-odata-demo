package org.anasoid.jmixjpaodatademo.entity.catalog;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.i18n.AbstractLocalizedItem;
import org.anasoid.jmixjpaodatademo.i18n.LocaleContext;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@JmixEntity
@Table(name = "PRODUCT", indexes = {
        @Index(columnList = "CODE, CATALOG_VERSION", unique = true)
})
@Entity
public class Product extends AbstractLocalizedItem {

    @NotBlank
    @Column(name = "CODE", nullable = false)
    private String code;

    @OnDeleteInverse(DeletePolicy.DENY)
    @NotNull
    @JoinColumn(name = "CATALOG_VERSION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private CatalogVersion catalogVersion;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")

    private LocalDateTime endDate;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Set<ProductLocalized> localizations = new HashSet<>();

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CatalogVersion getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(CatalogVersion catalogVersion) {
        this.catalogVersion = catalogVersion;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public String getName() {
//		With fallback language as English
        Map<String, ProductLocalized> toMap = localizations.stream().collect(Collectors.toMap(t -> t.getLocale(), t -> t));

        if (toMap.get(LocaleContext.getCurrentLocale()) == null) {
            if (toMap.get(LocaleContext.getDefaultLocale()) == null) {
                return null;
            } else {
                return toMap.get(LocaleContext.getDefaultLocale()).getName();
            }
        }
        return toMap.get(LocaleContext.getCurrentLocale()).getName();
    }

    public String getDescription() {
//		With fallback language as English
        Map<String, ProductLocalized> toMap = localizations.stream().collect(Collectors.toMap(t -> t.getLocale(), t -> t));
        if (toMap.get(LocaleContext.getCurrentLocale()) == null) {
            if (toMap.get(LocaleContext.getDefaultLocale()) == null) {
                return null;
            } else {
                return toMap.get(LocaleContext.getDefaultLocale()).getDescription();
            }
        }
        return toMap.get(LocaleContext.getCurrentLocale()).getDescription();
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductLocalized> getLocalizations() {
        return localizations;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}