package com.pacgame.event.eventHandler;

import com.pacgame.App;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnEscapeKey implements EventHandler<KeyEvent> {

    private Scene scene;

    public OnEscapeKey(Scene scene) {
        this.scene = scene;
    }


    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() != KeyCode.ESCAPE) {
            return;
        }

        if (App.isRunning()) {
            App.pause();
        } else {
            App.play();
        }
    }
}
