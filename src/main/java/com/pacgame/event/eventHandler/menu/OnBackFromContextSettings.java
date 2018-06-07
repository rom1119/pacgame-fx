package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.view.ContextSettings;
import com.pacgame.view.MainSettings;
import com.pacgame.view.Menu;
import javafx.event.ActionEvent;
import javafx.event.Event;

public class OnBackFromContextSettings extends MenuHandler {

    private ContextSettings contextSettings;

    public OnBackFromContextSettings(ContextSettings contextSettings, Menu mainMenu) {
        super(mainMenu);
        this.contextSettings = contextSettings;
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

        if (contextSettings.isVisible() && !App.isPlaying()) {
            menu.visible();
            contextSettings.invisible();
        }
    }
}
