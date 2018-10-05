package com.pacgame.board.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.ui.component.ContextMenu;
import javafx.event.EventHandler;
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
            contextMenu.show();
            App.pause();
        } else if(!App.isPlaying() && !contextMenu.isVisible()) {
            contextMenu.updateFocusMenuOption();
            View visibleComponentOnTop = App.getVisibleComponentOnTop();
            if (visibleComponentOnTop != null) {
                visibleComponentOnTop.hide();
            }
            contextMenu.show();
        } else {
            contextMenu.hide();
            App.play();
        }
    }
}
