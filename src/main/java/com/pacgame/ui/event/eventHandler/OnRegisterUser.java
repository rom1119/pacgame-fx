package com.pacgame.ui.event.eventHandler;

import com.pacgame.View;
import com.pacgame.ui.component.RegisterForm;
import javafx.event.Event;

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
