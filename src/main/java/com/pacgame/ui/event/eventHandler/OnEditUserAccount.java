package com.pacgame.ui.event.eventHandler;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.mainmenu.UserAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class OnEditUserAccount implements EventHandler<ActionEvent> {

    private UserAccount userAccount;
    private ApiService apiService;

    public OnEditUserAccount(UserAccount userAccount, ApiService apiService) {
        this.userAccount = userAccount;
        this.apiService = apiService;
    }


    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {

        if (!userAccount.isEditable()) {
            userAccount.setEditable(true);
            ((Button)event.getTarget()).setText("Zapisz");
            userAccount.changeLabelsOnInputs();
        } else {
            Token token = apiService.updateUser(createUser(userAccount));

            if (token.getErrorType() == Token.CREDENTIALS_ERROR) {
                userAccount.showFormErrors(token.getResponseError());
            } else if (token.getErrorType() == Token.SERVER_ERROR) {
                userAccount.showMainError("Problem z serwerem");
            } else {
                userAccount.changeInputsOnLabels();
                userAccount.showSuccessSaveMsg();

            }
        }
    }

    public User createUser(UserAccount userAccount)
    {
        User user = new User();
        user.getUserDetails().setFirstName(userAccount.getNameInput().getText());
        user.getUserDetails().setLastName(userAccount.getLastNameInput().getText());

        return user;
    }
}
