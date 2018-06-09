package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.view.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class OnBackToMenu implements EventHandler<ActionEvent> {

    private SubView thisView;

    public OnBackToMenu(SubView thisView) {
        this.thisView = thisView;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {

        if (thisView.isVisible() && !App.isPlaying()) {
            thisView.getMenu().visible();
            thisView.invisible();
        }
    }
}
