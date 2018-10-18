package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.ui.component.View;
import com.pacgame.board.service.PointPopulator;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnExitToMainMenuSelect extends MenuHandler {

    private Group rootPane;

    public OnExitToMainMenuSelect(View viewToHide, View viewToShow, Group rootPane) {
        super(viewToHide, viewToShow);
        this.rootPane = rootPane;
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
            getViewToShow().show();
            PointPopulator.depopulate(rootPane);
            App.pacmanController.deinitialize();
            App.clearAllMazesController();

            App.setRunningGame(false);
            App.mainMenu.updateFocusMenuOption();

        }
    }
}
