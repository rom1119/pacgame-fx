package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.ui.component.GameInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnLogout implements EventHandler<ActionEvent> {

    private GameInfo gameInfo;

    public OnLogout(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        App.setUser(null);
        App.setLoggedUser(false);

    }
}
