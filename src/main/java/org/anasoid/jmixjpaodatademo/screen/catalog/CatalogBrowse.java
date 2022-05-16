package org.anasoid.jmixjpaodatademo.screen.catalog;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.Catalog;

@UiController("Catalog.browse")
@UiDescriptor("catalog-browse.xml")
@LookupComponent("catalogsTable")
public class CatalogBrowse extends StandardLookup<Catalog> {
}