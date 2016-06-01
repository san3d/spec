package com.makarski.spec.webapp.page.user.panel;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.makarski.spec.dataaccess.filters.UserFilter;
import com.makarski.spec.datamodel.UserCredentials_;
import com.makarski.spec.datamodel.UserProfile;
import com.makarski.spec.datamodel.UserProfile_;
import com.makarski.spec.service.UserService;
import com.makarski.spec.webapp.page.user.UsersEditPage;

@AuthorizeAction(roles = { "admin" }, action = Action.RENDER)
public class UsersListPanel extends Panel {

    @Inject
    private UserService userService;

    public UsersListPanel(String id) {
        super(id);

        UsersDataProvider userDataProvider = new UsersDataProvider();
        DataView<UserProfile> dataView = new DataView<UserProfile>("rows", userDataProvider, 5) {
            @Override
            protected void populateItem(Item<UserProfile> item) {
                UserProfile user = item.getModelObject();
                item.add(new Label("id", user.getId()));
                item.add(new Label("fName", user.getFirstName()));
                item.add(new Label("email", user.getCredentials().getEmail()));
                item.add(new Link<Void>("edit-link") {
                    @Override
                    public void onClick() {
                        setResponsePage(new UsersEditPage(user));
                    }
                });

            }
        };
        add(dataView);
        add(new PagingNavigator("paging", dataView));

        add(new OrderByBorder("sort-id", UserProfile_.id, userDataProvider));
        add(new OrderByBorder("sort-name", UserProfile_.firstName, userDataProvider));
        add(new OrderByBorder("sort-email", UserCredentials_.email, userDataProvider));

    }

    private class UsersDataProvider extends SortableDataProvider<UserProfile, Serializable> {

        private UserFilter userFilter;

        public UsersDataProvider() {
            super();
            userFilter = new UserFilter();
            userFilter.setFetchCredentials(true);
            setSort((Serializable) UserProfile_.firstName, SortOrder.ASCENDING);
        }

        @Override
        public Iterator<UserProfile> iterator(long first, long count) {
            Serializable property = getSort().getProperty();
            SortOrder propertySortOrder = getSortState().getPropertySortOrder(property);

            userFilter.setSortProperty((SingularAttribute) property);
            userFilter.setSortOrder(propertySortOrder.equals(SortOrder.ASCENDING) ? true : false);

            userFilter.setLimit((int) count);
            userFilter.setOffset((int) first);
            return userService.find(userFilter).iterator();
        }

        @Override
        public long size() {
            return userService.count(userFilter);
        }

        @Override
        public IModel<UserProfile> model(UserProfile object) {
            return new Model(object);
        }

    }

}
