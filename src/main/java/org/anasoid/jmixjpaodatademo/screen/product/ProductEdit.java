package org.anasoid.jmixjpaodatademo.screen.product;

import io.jmix.ui.screen.*;
import org.anasoid.jmixjpaodatademo.entity.catalog.Product;

@UiController("Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
public class ProductEdit extends StandardEditor<Product> {
}