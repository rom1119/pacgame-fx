package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import com.pacgame.data.service.Api;
import com.pacgame.ui.component.LoginForm;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;


public class OnLoginUser extends MenuHandler {

    @Autowired
    private Api api;

    public OnLoginUser(View viewToHide, View viewToShow, Api api) {
        super(viewToHide, viewToShow);
        this.api = api;
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

        if (!loginForm.isValid()) {
            return;
        }

        User user = createUser(loginForm);
        try {
            Token token = api.postApiToken(user);

            if (!token.hasError()) {
                loginForm.hide();
                getViewToShow().show();
                loginForm.getLoginError().setVisible(false);
                App.setLoggedUser(true);
                user = api.getLoggedUser();
            } else {
                loginForm.getLoginError().setVisible(true);
            }
        } catch (ResourceAccessException e) {
            loginForm.getLoginError().setVisible(true);
            loginForm.getLoginError().setText("Problem z serwerem");
        } catch (HttpClientErrorException e) {
            loginForm.getLoginError().setVisible(true);
            loginForm.getLoginError().setText("Niepoprawne dane logowania");
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
