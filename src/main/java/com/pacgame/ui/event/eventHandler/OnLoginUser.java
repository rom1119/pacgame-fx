package com.pacgame.ui.event.eventHandler;

import com.pacgame.ui.component.View;
import com.pacgame.data.model.Token;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.mainmenu.LoginForm;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;


public class OnLoginUser extends MenuHandler {

    private ApiService apiService;

    public OnLoginUser(View viewToHide, View viewToShow, ApiService apiService) {
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
        LoginForm loginForm = (LoginForm) getViewToHide();

        if (!loginForm.isValid()) {
            return;
        }

        Token token = apiService.loginUser(loginForm.getEmailEl().getText(), loginForm.getPasswordEl().getText());

        if (!token.hasError()) {
            loginForm.hide();
            getViewToShow().show();
            loginForm.getEmailEl().setText("");
            loginForm.getPasswordEl().setText("");
            loginForm.getLoginError().setVisible(false);
        } else {
            if (token.getErrorType() == Token.CREDENTIALS_ERROR) {
                loginForm.getLoginError().setText("Niepoprawne dane logowania");
            } else if (token.getErrorType() == Token.SERVER_ERROR) {
                loginForm.getLoginError().setText("Problem z serwerem");
            }
            loginForm.getLoginError().setVisible(true);
        }


    }
}
