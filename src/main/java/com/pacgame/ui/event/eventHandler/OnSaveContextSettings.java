package com.pacgame.ui.event.eventHandler;

import com.pacgame.ui.component.contextmenu.ContextSettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class OnSaveContextSettings implements EventHandler<ActionEvent> {

    private ContextSettings changeGlobalSpeedMove;

    public OnSaveContextSettings(ContextSettings changeGlobalSpeedMove) {
        this.changeGlobalSpeedMove = changeGlobalSpeedMove;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {

        changeGlobalSpeedMove.changeGlobalSpeedMove();

    }
}
