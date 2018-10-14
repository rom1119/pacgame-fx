package com.pacgame.ui.event.eventHandler;

import com.pacgame.View;
import com.pacgame.data.model.User;
import com.pacgame.data.model.Token;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.RegisterForm;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import org.springframework.boot.configurationprocessor.json.JSONException;

public class OnRegisterUser extends MenuHandler {

    private ApiService apiService;

    public OnRegisterUser(View viewToHide, View viewToShow, ApiService apiService) {
        super(viewToHide, viewToShow);
        this.apiService = apiService;
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
        registerForm.resetErrors();

        if (!registerForm.isValid()) {
            return;
        }
        User user = createUser(registerForm);
        Token token = null;
            token = apiService.registerUser(user);

        System.out.println(token);
        System.out.println("token");
        if (token.getErrorType() == Token.CREDENTIALS_ERROR) {
            registerForm.showFormErrors(token.getResponseError());
        } else if (token.getErrorType() == Token.SERVER_ERROR) {
            registerForm.getMainError().setText("Problem z serwerem");
            registerForm.getMainError().setVisible(true);
        } else {
            registerForm.hide();
            getViewToShow().show();

        }

        System.out.println("register success");
    }

    private User createUser(RegisterForm registerForm)
    {
        User user = new User();
        user.setUsername(registerForm.getEmailEl().getText());
        user.setPassword(registerForm.getPasswordEl().getText());
        user.setConfirmPassword(registerForm.getPasswordConfEl().getText());

        return user;
    }
}
