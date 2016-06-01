package com.makarski.spec.webapp.page.attributes;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.makarski.spec.dataaccess.filters.AttributeFilter;
import com.makarski.spec.datamodel.Attribute;
import com.makarski.spec.datamodel.Attribute_;
import com.makarski.spec.service.AttributeService;

public class AttributesListPanel extends Panel {

    @Inject
    private AttributeService service;

    public AttributesListPanel(String id) {
        super(id);

        AttributesDataProvider AttributesDataProvider = new AttributesDataProvider();
        DataView<Attribute> dataView = new DataView<Attribute>("rows", AttributesDataProvider, 5) {
            @Override
            protected void populateItem(Item<Attribute> item) {
                Attribute attr = item.getModelObject();
                item.add(new Label("id", attr.getId()));
                item.add(new Label("name", attr.getName()));
                item.add(new Label("value", attr.getValue()));

            }
        };
        add(dataView);
        add(new PagingNavigator("paging", dataView));

        add(new OrderByBorder("sort-id", Attribute_.id, AttributesDataProvider));
        add(new OrderByBorder("sort-name", Attribute_.name, AttributesDataProvider));

    }

    private class AttributesDataProvider extends SortableDataProvider<Attribute, Serializable> {

        private AttributeFilter filter;

        public AttributesDataProvider() {
            super();
            filter = new AttributeFilter();
            setSort((Serializable) Attribute_.name, SortOrder.ASCENDING);
        }

        @Override
        public Iterator<Attribute> iterator(long first, long count) {
            Serializable property = getSort().getProperty();
            SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

            filter.setSortProperty((SingularAttribute) property);
            filter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

            filter.setLimit((int) count);
            filter.setOffset((int) first);
            return service.find(filter).iterator();
        }

        @Override
        public long size() {
            return service.count(filter);
        }

        @Override
        public IModel<Attribute> model(Attribute object) {
            return new Model<Attribute>(object);
        }

    }

}
