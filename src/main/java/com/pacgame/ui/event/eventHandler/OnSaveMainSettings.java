package com.pacgame.ui.event.eventHandler;

import com.pacgame.ui.component.MainSettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class OnSaveMainSettings implements EventHandler<ActionEvent> {

    private MainSettings mainSettings;
    public OnSaveMainSettings(MainSettings mainSettings) {
        this.mainSettings = mainSettings;
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
            mainSettings.changeGlobalSpeedMove();

        }
    }
}
