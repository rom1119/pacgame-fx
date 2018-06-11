package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.view.LoginForm;
import com.pacgame.view.RegisterForm;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

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
            App.setLoggedUser(true);
            System.out.println("login success");
        }
    }
}
