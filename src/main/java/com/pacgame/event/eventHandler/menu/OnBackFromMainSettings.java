package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.view.MainMenu;
import com.pacgame.view.MainSettings;
import com.pacgame.view.Menu;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class OnBackFromMainSettings extends MenuHandler {

    private MainSettings mainSettings;

    public OnBackFromMainSettings(MainSettings mainSettings, Menu mainMenu) {
        super(mainMenu);
        this.mainSettings = mainSettings;
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

        if (mainSettings.isVisible() && !App.isPlaying()) {
            menu.visible();
            mainSettings.invisible();
        }
    }
}
