package com.makarski.spec.webapp.page.user;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import com.makarski.spec.datamodel.UserCredentials;
import com.makarski.spec.webapp.app.AuthorizedSession;
import com.makarski.spec.webapp.page.AbstractPage;
import com.makarski.spec.webapp.page.user.panel.UsersListPanel;

@AuthorizeInstantiation(value = { "admin", "customer" })
public class UsersPage extends AbstractPage {

    public UsersPage() {
        super();

        UserCredentials loggedUser = AuthorizedSession.get().getLoggedUser();
        Roles roles = AuthorizedSession.get().getRoles();

        add(new UsersListPanel("list-panel"));
    }

}
