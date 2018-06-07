package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.view.Menu;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnStartNewGameSelect extends MenuHandler {

    public OnStartNewGameSelect(Menu menu) {
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
        KeyEvent event = (KeyEvent) e;
        if (event.getCode() != KeyCode.ENTER) {
            return;
        }
        if (menu.isVisible() && !App.isPlaying()) {
            App.pacmanController.setInitPosition();
            menu.invisible();
            App.clearAllMazesController();
            App.pause();
            App.entryTimer.startEntryTimer();
            App.setRunningGame(true);
            App.setPlaying(false);

        }
    }
}
