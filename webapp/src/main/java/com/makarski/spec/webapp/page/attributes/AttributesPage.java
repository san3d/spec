package com.makarski.spec.webapp.page.attributes;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.form.Form;

import com.makarski.spec.datamodel.Attribute;
import com.makarski.spec.webapp.page.AbstractPage;

public class AttributesPage extends AbstractPage {
    @Override
    protected void onInitialize() {
        super.onInitialize();

        AttributesListPanel attributesListPanel = new AttributesListPanel("list");
        attributesListPanel.setOutputMarkupId(true);
        add(attributesListPanel);

        addModalWindow(attributesListPanel);

        // addSearchComponents(attributesListPanel);
    }

    private void addSearchComponents(AttributesListPanel attributesListPanel) {
        Form form = new Form("searchForm");
        add(form);

        form.add(new AjaxSubmitLink("search-link") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                target.add(attributesListPanel);
            }
        });

    }

    private void addModalWindow(AttributesListPanel attributesListPanel) {
        ModalWindow modalWindow = new ModalWindow("modal");
        add(modalWindow);

        add(new AjaxLink("create") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                modalWindow.setContent(new AttributeEditPanel(modalWindow, new Attribute()));
                modalWindow.show(target);
            }
        });

        modalWindow.setWindowClosedCallback(new WindowClosedCallback() {

            @Override
            public void onClose(AjaxRequestTarget target) {
                target.add(attributesListPanel);

            }
        });
    }
}
