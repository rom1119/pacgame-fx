package com.pacgame.event.eventHandler;

import com.pacgame.App;
import com.pacgame.view.MainMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnEscapeKey implements EventHandler<KeyEvent> {

    private Scene scene;
    private MainMenu mainMenu;

    public OnEscapeKey(Scene scene, MainMenu mainMenu) {
        this.scene = scene;
        this.mainMenu = mainMenu;
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
            mainMenu.visible();
            App.pause();
        } else {
            mainMenu.invisible();
            App.play();
        }
    }
}
