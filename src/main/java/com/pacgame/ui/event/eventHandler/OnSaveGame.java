package com.pacgame.ui.event.eventHandler;

import com.pacgame.ui.component.contextmenu.ContextSaveGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class OnSaveGame implements EventHandler<ActionEvent> {

    private ContextSaveGame contextSaveGame;

    public OnSaveGame(ContextSaveGame contextSaveGame) {
        this.contextSaveGame = contextSaveGame;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {

        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setContentText("Czy jesteś pewien że chcesz zapisać zmiany ?");
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.get() == ButtonType.OK) {
            contextSaveGame.addListElement();

        }
    }
}
