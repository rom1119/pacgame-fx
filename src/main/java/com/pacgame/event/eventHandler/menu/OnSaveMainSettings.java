package com.pacgame.event.eventHandler.menu;

import com.pacgame.view.Menu;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

public class OnSaveMainSettings extends MenuHandler {
    public OnSaveMainSettings(Menu menu) {
        super(menu);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param e the event which occurred
     */
    @Override
    public void handle(Event e) {
        ActionEvent event = (ActionEvent) e;

    }
}
