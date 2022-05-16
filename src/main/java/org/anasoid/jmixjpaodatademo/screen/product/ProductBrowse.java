package org.anasoid.jmixjpaodatademo.screen.product;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.Product;

@UiController("Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
public class ProductBrowse extends StandardLookup<Product> {
}