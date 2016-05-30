package by.dzhivushko.training.shop.webapp.common;

import org.apache.wicket.markup.html.form.ChoiceRenderer;

import by.dzhivushko.training.shop.datamodel.UserRole;

public class UserRoleChoiceRenderer extends ChoiceRenderer<UserRole> {

    public static final UserRoleChoiceRenderer INSTANCE = new UserRoleChoiceRenderer();

    private UserRoleChoiceRenderer() {
        super();
    }

    @Override
    public Object getDisplayValue(UserRole object) {
        return object.name();
    }

    @Override
    public String getIdValue(UserRole object, int index) {
        return String.valueOf(object.ordinal());
    }
}
