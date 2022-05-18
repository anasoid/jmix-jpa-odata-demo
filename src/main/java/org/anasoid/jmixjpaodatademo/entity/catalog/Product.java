package org.anasoid.jmixjpaodatademo.entity.catalog;

import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.i18n.AbstractLocalizedItem;
import org.anasoid.jmixjpaodatademo.i18n.LocaleContext;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@JmixEntity
@Table(name = "PRODUCT", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_PRODUCT_CODE_CV_UNQ", columnNames = {"CODE", "CATALOG_VERSION"})
})
@Entity
public class Product extends AbstractLocalizedItem<ProductLocalized> {

    @NotBlank
    @Column(name = "CODE", nullable = false, updatable = false)
    private String code;


    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 250)
    private String description;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")

    private LocalDateTime endDate;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Composition
    private Set<ProductLocalized> localizations = new HashSet<>();


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


    public String getName() {
//		With fallback language as English
        Map<String, ProductLocalized> toMap = localizations.stream().collect(Collectors.toMap(t -> t.getLanguage().getId(), t -> t));

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
        Map<String, ProductLocalized> toMap = localizations.stream().collect(Collectors.toMap(t -> t.getLanguage().getId(), t -> t));
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

    @InstanceName

    public String getInstanceName() {
        return String.format("%s (%s)",  code, getPk());
    }
}