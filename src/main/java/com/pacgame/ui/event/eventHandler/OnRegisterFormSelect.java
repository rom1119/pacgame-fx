package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.ui.component.RegisterForm;
import com.pacgame.ui.event.MenuHandler;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnRegisterFormSelect extends MenuHandler {

    public OnRegisterFormSelect(View viewToHide, View viewToShow) {
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


        if (!App.isPlaying()) {
            RegisterForm viewToShow = (RegisterForm) this.viewToShow;
            viewToShow.resetErrors();
            viewToShow.resetFields();
            getViewToHide().hide();
            getViewToShow().show();
        }
    }

}
