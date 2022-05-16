package org.anasoid.jmixjpaodatademo.entity.i18n;

import io.jmix.core.metamodel.annotation.JmixEntity;
import org.anasoid.jmixjpaodatademo.entity.AbstractItem;

import javax.persistence.MappedSuperclass;

@JmixEntity
@MappedSuperclass
public class AbstractLocalizedItem extends AbstractItem {
}