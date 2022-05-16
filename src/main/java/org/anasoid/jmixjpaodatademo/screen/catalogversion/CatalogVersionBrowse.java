package org.anasoid.jmixjpaodatademo.screen.catalogversion;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.CatalogVersion;

@UiController("CatalogVersion.browse")
@UiDescriptor("catalog-version-browse.xml")
@LookupComponent("catalogVersionsTable")
public class CatalogVersionBrowse extends StandardLookup<CatalogVersion> {
}