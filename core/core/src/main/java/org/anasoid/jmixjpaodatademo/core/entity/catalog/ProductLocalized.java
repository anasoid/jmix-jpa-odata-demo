package org.anasoid.jmixjpaodatademo.core.entity.catalog;

import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.core.entity.i18n.Localized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@JmixEntity
@Table(name = "PRODUCT_LOCALIZED", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_PRODUCT_LOCALIZED_UNQ", columnNames = {"ITEM_PK", "LANG"})
})
@Entity
public class ProductLocalized extends Localized<Product> {

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 9999)
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}