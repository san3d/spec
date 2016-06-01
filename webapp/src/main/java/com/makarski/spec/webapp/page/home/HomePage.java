package com.makarski.spec.webapp.page.home;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.form.palette.Palette;
import org.apache.wicket.extensions.markup.html.form.palette.theme.DefaultTheme;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.CollectionModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.apache.wicket.util.time.Duration;

import com.makarski.spec.dataaccess.filters.AttributeFilter;
import com.makarski.spec.dataaccess.filters.ProductFilter;
import com.makarski.spec.datamodel.Attribute;
import com.makarski.spec.datamodel.Product;
import com.makarski.spec.datamodel.ProductVariant;
import com.makarski.spec.service.AttributeService;
import com.makarski.spec.service.ProductService;
import com.makarski.spec.service.ProductVariantService;
import com.makarski.spec.webapp.common.AttributeChoiceRenderer;
import com.makarski.spec.webapp.common.ProductChoiceRenderer;
import com.makarski.spec.webapp.page.AbstractPage;

public class HomePage extends AbstractPage {

    @Inject
    private AttributeService attributeService;

    @Inject
    private ProductVariantService productVariantService;

    @Inject
    private ProductService productService;

    private ProductVariant productVariant;

    private int fontSize = 14;

    public HomePage(PageParameters parameters) {
        super(parameters);
        StringValue idAsString = parameters.get("id");
        productVariant = productVariantService.get(Long.valueOf(idAsString.toString()));
    }

    public HomePage() {
        super();
        productVariant = new ProductVariant();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<ProductVariant> form = new Form<ProductVariant>("form", new CompoundPropertyModel<>(productVariant));
        add(form);

        form.add(new TextField<>("priceInfluence"));
        form.add(new TextField<>("name"));
        List<Product> allProducts = productService.find(new ProductFilter());
        form.add(new DropDownChoice<>("product", allProducts, ProductChoiceRenderer.INSTANCE));

        List<Attribute> allAttributes = attributeService.find(new AttributeFilter());
        final Palette<Attribute> palette = new Palette<Attribute>("attributes", Model.ofList(productVariant.getAttributes()), new CollectionModel<Attribute>(
                allAttributes), AttributeChoiceRenderer.INSTANCE, 15, false, true);
        palette.add(new DefaultTheme());
        form.add(palette);

        form.add(new SubmitLink("save") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                productVariantService.saveOrUpdate(productVariant);
                setResponsePage(new HomePage());
            }
        });

        Model<Integer> counterModel = new Model<Integer>();
        counterModel.setObject(0);
        Label label = new Label("counter", counterModel);
        label.setOutputMarkupId(true);
        label.setOutputMarkupPlaceholderTag(true);
        add(label);

        add(new AjaxLink<Void>("btn-increment") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                incrementAndUpdate(counterModel, label, target);
            }
        });

        label.add(new AjaxEventBehavior("mouseover") {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                fontSize = fontSize + 2;
                label.add(AttributeModifier.replace("style", "font-size:" + fontSize + "px"));
                target.add(label);
            }
        });
        /*
         * label.add(new AjaxEventBehavior("click") {
         * 
         * @Override protected void onEvent(AjaxRequestTarget target) { fontSize
         * = 15; label.add(AttributeModifier.replace("style", "font-size:" +
         * fontSize + "px")); target.add(label); } });
         */

        // Timer //
        final AbstractAjaxTimerBehavior timer = new AbstractAjaxTimerBehavior(Duration.seconds(1)) {
            @Override
            protected void onTimer(final AjaxRequestTarget target) {
                incrementAndUpdate(counterModel, label, target);
            }
        };
        add(timer);

    }

    private void incrementAndUpdate(Model<Integer> counterModel, Label label, AjaxRequestTarget target) {
        counterModel.setObject(counterModel.getObject() + 1);
        target.add(label);
    }
}
