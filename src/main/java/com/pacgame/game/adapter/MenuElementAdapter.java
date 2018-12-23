package com.pacgame.game.adapter;

import com.pacgame.game.IHandler;
import com.pacgame.game.IMenuItem;
import com.pacgame.game.event.ui.UIEventHandler;
import com.pacgame.uiElement.menu.MenuElement;

public class MenuElementAdapter implements IMenuItem {

    private MenuElement menuElement;

    public MenuElementAdapter(MenuElement menuElement) {
        this.menuElement = menuElement;
    }



    @Override
    public void setOnSelect(UIEventHandler handler) {

    }

    @Override
    public void setText(String text) {
        menuElement.setText(text);
    }

    public MenuElement getProvidedObject()
    {
        return menuElement;
    }
}
