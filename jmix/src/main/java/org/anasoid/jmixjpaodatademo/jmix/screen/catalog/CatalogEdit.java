package org.anasoid.jmixjpaodatademo.jmix.screen.catalog;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.core.entity.catalog.Catalog;

@UiController("Catalog.edit")
@UiDescriptor("catalog-edit.xml")
@EditedEntityContainer("catalogDc")
public class CatalogEdit extends StandardEditor<Catalog> {
}