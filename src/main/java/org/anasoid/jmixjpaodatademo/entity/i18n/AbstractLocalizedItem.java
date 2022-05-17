package org.anasoid.jmixjpaodatademo.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.AbstractAuditableItem;
import org.anasoid.jmixjpaodatademo.entity.AbstractItem;
import org.anasoid.jmixjpaodatademo.entity.catalog.ProductLocalized;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.Set;

@JmixEntity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractLocalizedItem<T extends Localized<?>> extends AbstractAuditableItem {

    public abstract Set<T> getLocalizations();
}