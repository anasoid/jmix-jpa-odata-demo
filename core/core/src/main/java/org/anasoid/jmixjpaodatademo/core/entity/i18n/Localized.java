package org.anasoid.jmixjpaodatademo.core.entity.i18n;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmAlias;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.core.entity.AbstractItem;
import org.anasoid.jmixjpaodatademo.core.entity.catalog.Product;
import org.anasoid.jmixjpaodatademo.core.entity.catalog.ProductLocalized;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/*@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"LOCALE", "ITEM_PK"})
})*/


@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localized<T extends AbstractLocalizedItem> extends AbstractItem {

    @Column(name = "LANG", nullable = false)
    @NotNull
    @EdmAlias(name = "language")
    private String language;

    @JoinColumn(name = "LANG", nullable = false, updatable = false, insertable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @EdmIgnore
    private Language lang;


    public abstract void setItem(T item);

    public abstract T getItem();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }
}