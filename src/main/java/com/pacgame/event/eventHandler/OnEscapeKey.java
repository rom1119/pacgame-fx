package com.pacgame.event.eventHandler;

import com.pacgame.App;
import com.pacgame.view.ContextMenu;
import com.pacgame.view.MainMenu;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnEscapeKey implements EventHandler<KeyEvent> {

    private ContextMenu contextMenu;

    public OnEscapeKey(ContextMenu contextMenu) {
        this.contextMenu = contextMenu;
    }


    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() != KeyCode.ESCAPE || !App.isRunningGame()) {
            return;
        }

        if (App.isPlaying()) {
            contextMenu.updateFocusMenuOption();
            contextMenu.visible();
            App.pause();
        } else {
            contextMenu.invisible();
            App.play();
        }
    }
}
