package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.data.model.User;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.UsersRanking;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class OnUsersRankingSelect extends MenuHandler {

    private ApiService apiService;


    public OnUsersRankingSelect(View viewToHide, View viewToShow, ApiService apiService) {
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
        UsersRanking usersRanking = (UsersRanking) getViewToShow();

        if (event instanceof KeyEvent) {
            if (((KeyEvent)event).getCode() != KeyCode.ENTER) {
                return;
            }
        }
        if (!App.isLoggedUser()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja o logowaniu");
            alert.setHeaderText(null);
            alert.setContentText("Aby wejść w tą sekcję musisz sie zalogować.");

            alert.showAndWait();

            return;
        }

        List<User> users = apiService.getUsers();
        usersRanking.getData().clear();
        usersRanking.getData().addAll(users);



        getViewToHide().hide();
        getViewToShow().show();
    }
}
