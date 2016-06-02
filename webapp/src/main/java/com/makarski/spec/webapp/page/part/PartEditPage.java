package com.makarski.spec.webapp.page.part;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.RangeValidator;

import com.makarski.spec.datamodel.Part;
import com.makarski.spec.service.PartService;
import com.makarski.spec.webapp.page.AbstractPage;

public class PartEditPage extends AbstractPage {

    @Inject
    private ProductService productService;

    private Product product;

    public ProductEditPage(PageParameters parameters) {
        super(parameters);
    }

    public ProductEditPage(Product product) {
        super();
        this.product = product;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<Product> form = new ProductForm<Product>("form", new CompoundPropertyModel<Product>(product));
        add(form);

        TextField<String> nameField = new TextField<>("name");

        nameField.setVisible(product.getId() == null);
        nameField.setRequired(true);
        form.add(nameField);

        TextField<Double> basePriceField = new TextField<>("basePrice");
        basePriceField.add(RangeValidator.<Double> range(0d, 1_000_000d));
        basePriceField.setRequired(true);

        DateTextField createdField = new DateTextField("created");
        createdField.add(new DatePicker());
        createdField.setRequired(true);
        form.add(createdField);

        form.add(basePriceField);

        CheckBox activeField = new CheckBox("active");
        form.add(activeField);

        form.add(new SubmitLink("save") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                productService.saveOrUpdate(product);
                setResponsePage(new ProductsPage());
            }
        });

        add(new FeedbackPanel("feedback"));
    }

    @AuthorizeAction(roles = { "admin" }, action = Action.ENABLE)
    private class ProductForm<T> extends Form<T> {

        public ProductForm(String id, IModel<T> model) {
            super(id, model);
        }
    }
}
