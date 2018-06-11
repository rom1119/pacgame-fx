package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.view.MainMenu;
import com.pacgame.view.Menu;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnUserAccountSelect extends MenuHandler {

    public OnUserAccountSelect(View viewToHide, View viewToShow) {
        super(viewToHide, viewToShow);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(Event event) {
        if (event instanceof KeyEvent) {
            if (((KeyEvent)event).getCode() != KeyCode.ENTER) {
                return;
            }
        }
        if (!App.isLoggedUser()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja o logowaniu");
            alert.setHeaderText(null);
            alert.setContentText("Aby wejść w tą sekcję musisz sie zalogować.");

            alert.showAndWait();
        }

        getViewToHide().hide();
        getViewToShow().show();

    }
}
