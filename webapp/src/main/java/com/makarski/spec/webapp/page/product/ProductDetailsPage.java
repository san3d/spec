package com.makarski.spec.webapp.page.product;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.makarski.spec.datamodel.Product;
import com.makarski.spec.webapp.page.AbstractPage;

public class ProductDetailsPage extends AbstractPage {

    public ProductDetailsPage(PageParameters parameters) {
        super(parameters);
    }

    public ProductDetailsPage(Product product) {
        super();

    }

}
