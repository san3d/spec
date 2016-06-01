package com.makarski.spec.webapp.common;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import com.makarski.spec.datamodel.Part;

public class ProductChoiceRenderer extends ChoiceRenderer<Product> {

    public static final ProductChoiceRenderer INSTANCE = new ProductChoiceRenderer();

    private ProductChoiceRenderer() {
        super();
    }

    @Override
    public Object getDisplayValue(Part object) {
        return object.getName();
    }

    @Override
    public String getIdValue(Part object, int index) {
        return String.valueOf(object.getId());
    }
}
