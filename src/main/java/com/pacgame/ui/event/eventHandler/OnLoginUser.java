package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.board.model.User;
import com.pacgame.ui.component.LoginForm;
import javafx.event.Event;

public class OnLoginUser extends MenuHandler {

    public OnLoginUser(View viewToHide, View viewToShow) {
        super(viewToHide, viewToShow);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(Event event) {
        LoginForm loginForm = (LoginForm) getViewToHide();

        if (loginForm.isValid()) {
            loginForm.hide();
            getViewToShow().show();
            createUser(loginForm);
            App.setLoggedUser(true);
            System.out.println("login success");
        }
    }


    private void createUser(LoginForm loginForm) {

        User user = new User();
        user.setEmail(loginForm.getEmailEl().getText());

        App.setUser(user);
    }
}
