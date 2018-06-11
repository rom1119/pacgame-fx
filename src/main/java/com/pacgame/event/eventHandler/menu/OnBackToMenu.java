package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.view.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class OnBackToMenu extends MenuHandler{

    public OnBackToMenu(View viewToHide, View viewToShow) {
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
        ActionEvent event = (ActionEvent) e;
        if (getViewToHide().isVisible() && !App.isPlaying()) {
            getViewToHide().hide();
            getViewToShow().show();
        }
    }
}
