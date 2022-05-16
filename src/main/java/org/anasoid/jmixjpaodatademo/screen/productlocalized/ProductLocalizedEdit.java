package org.anasoid.jmixjpaodatademo.screen.productlocalized;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.ProductLocalized;

@UiController("ProductLocalized.edit")
@UiDescriptor("product-localized-edit.xml")
@EditedEntityContainer("productLocalizedDc")
public class ProductLocalizedEdit extends StandardEditor<ProductLocalized> {
}