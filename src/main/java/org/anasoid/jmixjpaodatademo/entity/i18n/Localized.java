package org.anasoid.jmixjpaodatademo.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.AbstractItem;
import org.anasoid.jmixjpaodatademo.entity.catalog.Product;
import org.anasoid.jmixjpaodatademo.entity.catalog.ProductLocalized;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/*@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"LOCALE", "ITEM_PK"})
})*/


@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localized<T extends AbstractLocalizedItem> extends AbstractItem {


    @Column(name = "LANG", length = 10, nullable = false, updatable = false)
    @NotNull
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_PK", nullable = false, updatable = false)
    @NotNull
    private T item;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}