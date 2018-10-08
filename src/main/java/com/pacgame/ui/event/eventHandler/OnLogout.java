package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.data.service.ApiService;
import com.pacgame.ui.component.GameInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnLogout implements EventHandler<ActionEvent> {

    private GameInfo gameInfo;
    private ApiService apiService;


    public OnLogout(GameInfo gameInfo, ApiService apiService) {
        this.gameInfo = gameInfo;
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
        if (!apiService.logoutUser()) {
            gameInfo.showAlert("Wystąpił problem podczas wylogowania.");
        }

    }
}
