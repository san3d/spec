package com.makarski.spec.webapp.page;

import java.util.Calendar;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.makarski.spec.webapp.component.menu.MenuPanel;

public abstract class AbstractPage extends WebPage {

    public AbstractPage() {
        super();
    }

    public AbstractPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new MenuPanel("menu-panel"));

        AbstractReadOnlyModel<Integer> yearModel = new AbstractReadOnlyModel<Integer>() {
            @Override
            public Integer getObject() {
                return Calendar.getInstance().get(Calendar.YEAR);
            }
        };

        WebMarkupContainer footer = new WebMarkupContainer("footer");
        add(footer);
        footer.add(new Label("current-year", yearModel));
        footer.add(AttributeModifier.append("onclick", "alert('Im clicked')"));
    }
}
