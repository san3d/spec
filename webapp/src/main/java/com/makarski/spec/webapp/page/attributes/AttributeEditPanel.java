package com.makarski.spec.webapp.page.attributes;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.makarski.spec.datamodel.Attribute;
import com.makarski.spec.service.AttributeService;

public class AttributeEditPanel extends Panel {

    @Inject
    private AttributeService attributeService;

    private Attribute attr;

    private ModalWindow modalWindow;

    public AttributeEditPanel(ModalWindow modalWindow, Attribute attr) {
        super(modalWindow.getContentId());
        this.attr = attr;
        this.modalWindow = modalWindow;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Form<Attribute> form = new Form<>("form", new CompoundPropertyModel<>(attr));
        add(form);

        form.add(new TextField<>("name"));
        form.add(new TextField<>("value"));

        form.add(new AjaxSubmitLink("save") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                attributeService.saveOrUpdate(attr);
                modalWindow.close(target);
            }
        });

        form.add(new AjaxLink("cancel") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                modalWindow.close(target);
            }
        });
    }
}
