package com.makarski.spec.webapp.page.product;

import javax.inject.Inject;

import com.makarski.spec.service.ProductService;
import com.makarski.spec.webapp.page.AbstractPage;
import com.makarski.spec.webapp.page.product.panel.ProductListPanel;

public class ProductsPage extends AbstractPage {

    @Inject
    private ProductService productService;

    public ProductsPage() {
        super();
        add(new ProductListPanel("list-panel"));
    }

}
