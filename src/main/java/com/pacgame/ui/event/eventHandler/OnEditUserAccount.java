package com.pacgame.ui.event.eventHandler;

import com.pacgame.data.model.User;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.mainmenu.UserAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
            userAccount.changeLabelsOnInputs();
        } else {
            apiService.updateUser(createUser(userAccount));

        }
    }

    public User createUser(UserAccount userAccount)
    {
        User user = new User();
        user.getUserDetails().setFirstName(userAccount.getNameEl().getText());
        user.getUserDetails().setLastName(userAccount.getLastNameEl().getText());
        user.getUserDetails().setFile(userAccount.getImage());

        return user;
    }
}
