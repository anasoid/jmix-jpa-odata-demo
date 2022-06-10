package org.anasoid.jmixjpaodatademo.jmix.screen.catalogversion;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.core.entity.catalog.CatalogVersion;

@UiController("CatalogVersion.edit")
@UiDescriptor("catalog-version-edit.xml")
@EditedEntityContainer("catalogVersionDc")
public class CatalogVersionEdit extends StandardEditor<CatalogVersion> {
}