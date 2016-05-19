package com.makarski.spec.webapp.page.product.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.makarski.spec.dataaccess.filters.ProductFilter;
import com.makarski.spec.datamodel.Product;
import com.makarski.spec.datamodel.Product_;
import com.makarski.spec.service.ProductService;

public class ProductListPanel extends Panel {

    @Inject
    private ProductService productService;

    public ProductListPanel(String id) {
        super(id);

        ProductsDataProvider productsDataProvider = new ProductsDataProvider();
        DataView<Product> dataView = new DataView<Product>("rows", productsDataProvider, 5) {
            @Override
            protected void populateItem(Item<Product> item) {
                Product product = item.getModelObject();

                item.add(new Label("id", product.getId()));
                item.add(new Label("name", product.getName()));
                item.add(new Label("price", product.getBasePrice()));
                item.add(DateLabel.forDatePattern("created", Model.of(product.getCreated()), "dd-MM-yyyy"));

                CheckBox checkbox = new CheckBox("active", Model.of(product.getActive()));
                checkbox.setEnabled(false);
                item.add(checkbox);
            }
        };
        add(dataView);
        add(new PagingNavigator("paging", dataView));

        add(new OrderByBorder("sort-id", Product_.id, productsDataProvider));
        add(new OrderByBorder("sort-name", Product_.name, productsDataProvider));
        add(new OrderByBorder("sort-price", Product_.basePrice, productsDataProvider));

    }

    private class ProductsDataProvider extends SortableDataProvider<Product, Serializable> {

        private ProductFilter productFilter;

        public ProductsDataProvider() {
            super();
            productFilter = new ProductFilter();
            setSort((Serializable) Product_.name, SortOrder.ASCENDING);
        }

        @Override
        public Iterator<Product> iterator(long first, long count) {
            Serializable property = getSort().getProperty();
            SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

            productFilter.setSortProperty((SingularAttribute) property);
            productFilter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

            productFilter.setLimit((int) count);
            productFilter.setOffset((int) first);
            return productService.find(productFilter).iterator();
        }

        @Override
        public long size() {
            return productService.count(productFilter);
        }

        @Override
        public IModel<Product> model(Product object) {
            return new Model(object);
        }

    }

}
