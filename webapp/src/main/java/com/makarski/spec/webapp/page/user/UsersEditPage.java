package com.makarski.spec.webapp.page.user;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.makarski.spec.datamodel.UserCredentials;
import com.makarski.spec.datamodel.UserProfile;
import com.makarski.spec.datamodel.UserRole;
import com.makarski.spec.service.UserService;
import com.makarski.spec.webapp.common.UserRoleChoiceRenderer;
import com.makarski.spec.webapp.page.AbstractPage;

public class UsersEditPage extends AbstractPage {

    @Inject
    private UserService userService;

    private UserCredentials credentials;

    public UsersEditPage(UserProfile user) {
        super();
        this.credentials = userService.getCredentials(user.getId());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Form<UserCredentials> form = new Form<UserCredentials>("form", new CompoundPropertyModel<UserCredentials>(credentials));
        add(form);

        DropDownChoice<UserRole> roleField = new DropDownChoice<>("role", Arrays.asList(UserRole.values()), UserRoleChoiceRenderer.INSTANCE);
        roleField.setRequired(true);
        form.add(roleField);

        form.add(new SubmitLink("save") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                userService.update(credentials);
                setResponsePage(new UsersPage());
            }
        });

        add(new FeedbackPanel("feedback"));
    }

}
