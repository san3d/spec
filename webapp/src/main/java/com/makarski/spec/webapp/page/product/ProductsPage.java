package com.makarski.spec.webapp.page.product;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.Link;

import com.makarski.spec.datamodel.Product;
import com.makarski.spec.webapp.page.AbstractPage;
import com.makarski.spec.webapp.page.product.panel.ProductListPanel;

@AuthorizeInstantiation(value = { "admin", "customer" })
public class ProductsPage extends AbstractPage {

    public ProductsPage() {
        super();
        add(new ProductListPanel("list-panel"));

        add(new Link("create") {
            @Override
            public void onClick() {
                setResponsePage(new ProductEditPage(new Product()));
            }
        });
    }

}
