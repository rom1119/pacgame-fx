package com.pacgame.event.eventHandler.menu;

import com.pacgame.App;
import com.pacgame.view.ContextMenu;
import com.pacgame.view.MainMenu;
import com.pacgame.view.Menu;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnReadGameSelect extends MenuHandler {

    public OnReadGameSelect(Menu menu) {
        super(menu);
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
        if (event.getCode() != KeyCode.ENTER) {
            return;
        }
        if (getMenu().isVisible() && !App.isPlaying()) {
            getMenu().invisible();
            ((MainMenu)getMenu()).getMainReadGame().visible();
        }
    }
}
