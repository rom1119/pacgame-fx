package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.ui.component.View;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnResumeGameSelect extends MenuHandler {

    public OnResumeGameSelect(View viewToHide, View viewToShow) {
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
        if (event.getCode() != KeyCode.ENTER || !App.isRunningGame()) {
            return;
        }

        if (!App.isPlaying()) {
            getViewToHide().hide();
            App.play();
        }
    }
}
