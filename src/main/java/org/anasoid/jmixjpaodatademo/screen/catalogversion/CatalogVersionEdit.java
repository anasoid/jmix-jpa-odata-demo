package org.anasoid.jmixjpaodatademo.screen.catalogversion;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.CatalogVersion;

@UiController("CatalogVersion.edit")
@UiDescriptor("catalog-version-edit.xml")
@EditedEntityContainer("catalogVersionDc")
public class CatalogVersionEdit extends StandardEditor<CatalogVersion> {
}