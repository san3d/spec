package com.makarski.spec.webapp.component.menu;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import com.makarski.spec.webapp.app.AuthorizedSession;
import com.makarski.spec.webapp.page.attributes.AttributesPage;
import com.makarski.spec.webapp.page.home.HomePage;
import com.makarski.spec.webapp.page.login.LoginPage;
import com.makarski.spec.webapp.page.part.ProductsPage;
import com.makarski.spec.webapp.page.user.UsersPage;

public class MenuPanel extends Panel {

    public MenuPanel(String id) {
        super(id);
        // setRenderBodyOnly(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new Link("link-home") {
            @Override
            public void onClick() {
                setResponsePage(new HomePage());
            }
        });

        add(new Link("link-products") {
            @Override
            public void onClick() {
                setResponsePage(new ProductsPage());
            }
        });

        add(new Link("link-users") {
            @Override
            public void onClick() {
                setResponsePage(new UsersPage());
            }
        });

        add(new Link("link-attributes") {
            @Override
            public void onClick() {
                setResponsePage(new AttributesPage());
            }
        });

        Link link = new Link("link-logout") {
            @Override
            public void onClick() {
                getSession().invalidate();
                setResponsePage(LoginPage.class);
            }
        };
        link.setVisible(AuthorizedSession.get().isSignedIn());
        add(link);

    }
}
