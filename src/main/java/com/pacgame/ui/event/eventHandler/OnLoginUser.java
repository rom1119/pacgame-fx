package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.data.model.User;
import com.pacgame.ui.component.LoginForm;
import com.pacgame.ui.event.MenuHandler;
import com.pacgame.data.service.ApiImpl;
import javafx.event.Event;

import java.io.UnsupportedEncodingException;

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
            User user = createUser(loginForm);

            try {
                ApiImpl.loginUser(user);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            App.setLoggedUser(true);
            System.out.println("login success");
        }
    }


    private User createUser(LoginForm loginForm) {

        User user = new User();
        user.setEmail(loginForm.getEmailEl().getText());
        user.setPassword(loginForm.getPasswordEl().getText());

        App.setUser(user);

        return user;
    }
}
