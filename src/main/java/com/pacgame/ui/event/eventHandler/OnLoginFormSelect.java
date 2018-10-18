package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.ui.component.View;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class OnLoginFormSelect extends MenuHandler {

    public OnLoginFormSelect(View viewToHide, View viewToShow) {
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
        if (App.isLoggedUser()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja o logowaniu");
            alert.setHeaderText(null);
            alert.setContentText("Aby się zalogować na konto innego użytkownika musisz sie wylogować.");

            alert.showAndWait();
        }

        getViewToHide().hide();
        getViewToShow().show();

    }
}
