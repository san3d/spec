package com.makarski.spec.webapp.common;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import com.makarski.spec.datamodel.Part;

public class PartChoiceRenderer extends ChoiceRenderer<Part> {

    public static final PartChoiceRenderer INSTANCE = new PartChoiceRenderer();

    private PartChoiceRenderer() {
        super();
    }

    @Override
    public Object getDisplayValue(Part object) {
        return String.format("%s:%s", object.getSpecification(), object.getValue());
    }

    @Override
    public String getIdValue(Attribute object, int index) {
        return String.valueOf(object.getId());
    }
}
