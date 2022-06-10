package org.anasoid.jmixjpaodatademo.jmix.screen.productlocalized;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.core.entity.catalog.ProductLocalized;

@UiController("ProductLocalized.browse")
@UiDescriptor("product-localized-browse.xml")
@LookupComponent("productLocalizedsTable")
public class ProductLocalizedBrowse extends StandardLookup<ProductLocalized> {
}