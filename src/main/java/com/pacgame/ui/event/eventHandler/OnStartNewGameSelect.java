package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnStartNewGameSelect extends MenuHandler {

    public OnStartNewGameSelect(View viewToHide, View viewToShow) {
        super(viewToHide, viewToShow);
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
        if (getViewToHide().isVisible() && !App.isPlaying()) {
            App.pacmanController.setInitPosition();
            getViewToHide().hide();
            App.clearAllMazesController();
            App.pause();
            App.entryTimer.startEntryTimer();
            App.setRunningGame(true);
            App.setPlaying(false);

        }
    }
}
