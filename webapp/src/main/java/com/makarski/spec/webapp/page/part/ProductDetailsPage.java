package com.makarski.spec.webapp.page.part;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.makarski.spec.datamodel.Part;
import com.makarski.spec.webapp.page.AbstractPage;

public class PartDetailsPage extends AbstractPage {

    public PartDetailsPage(PageParameters parameters) {
        super(parameters);
    }

    public PartDetailsPage(Part Part) {
        super();

    }

}
