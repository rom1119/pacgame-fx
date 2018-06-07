package com.pacgame.event.eventHandler.menu;

import com.pacgame.view.Menu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;

public abstract class MenuHandler implements EventHandler {

    protected Menu menu;

    public MenuHandler(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
