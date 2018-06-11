package com.pacgame.event.eventHandler.menu;

import com.pacgame.View;
import com.pacgame.view.RegisterForm;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class OnRegisterUser extends MenuHandler {

    public OnRegisterUser(View viewToHide, View viewToShow) {
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
        RegisterForm registerForm = (RegisterForm) getViewToHide();
        if (registerForm.isValid()) {
            registerForm.hide();
            getViewToShow().show();
            System.out.println("register success");
        }
    }
}
