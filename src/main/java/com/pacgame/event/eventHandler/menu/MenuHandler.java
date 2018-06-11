package com.pacgame.event.eventHandler.menu;

import com.pacgame.View;
import com.pacgame.view.Menu;
import javafx.event.EventHandler;

public abstract class MenuHandler implements EventHandler {

    protected View viewToHide;
    protected View viewToShow;

    public MenuHandler(View viewToHide, View viewToShow) {
        this.viewToHide = viewToHide;
        this.viewToShow = viewToShow;
    }

    public View getViewToHide() {
        return viewToHide;
    }

    public void setViewToHide(View viewToHide) {
        this.viewToHide = viewToHide;
    }

    public View getViewToShow() {
        return viewToShow;
    }

    public void setViewToShow(View viewToShow) {
        this.viewToShow = viewToShow;
    }
}
