package org.anasoid.jmixjpaodatademo.entity.i18n;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.AbstractItem;
import org.anasoid.jmixjpaodatademo.entity.catalog.Product;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


/*@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"LOCALE", "ITEM_PK"})
})*/


@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localized<T extends AbstractLocalizedItem> extends AbstractItem {


    @Column(name = "LOCALE", length = 10)
    private String locale;

    @ManyToOne
    @JoinColumn(name = "ITEM_PK", nullable = false)
    private Product item;


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }


    public void setItem(Product item) {
        this.item = item;
    }

    public Product getItem() {
        return item;
    }
}