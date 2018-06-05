package com.pacgame.event.eventHandler;

import com.pacgame.App;
import com.pacgame.view.MainMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnExitSelect implements EventHandler<KeyEvent> {

    private MainMenu mainMenu;

    public OnExitSelect(MainMenu mainMenu) {
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
        if (event.getCode() != KeyCode.ENTER) {
            return;
        }
        if (mainMenu.isVisible() && !App.isRunning()) {
            App.exit();
        }
    }
}
