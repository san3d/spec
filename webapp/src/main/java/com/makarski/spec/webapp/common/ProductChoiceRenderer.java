package by.dzhivushko.training.shop.webapp.common;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.dzhivushko.training.shop.datamodel.Product;

public class ProductChoiceRenderer extends ChoiceRenderer<Product> {

    public static final ProductChoiceRenderer INSTANCE = new ProductChoiceRenderer();

    private ProductChoiceRenderer() {
        super();
    }

    @Override
    public Object getDisplayValue(Product object) {
        return object.getName();
    }

    @Override
    public String getIdValue(Product object, int index) {
        return String.valueOf(object.getId());
    }
}
