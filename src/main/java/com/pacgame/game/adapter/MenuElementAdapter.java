package com.pacgame.game.adapter;

import com.pacgame.game.IHandler;
import com.pacgame.game.IMenuItem;
import com.pacgame.uiElement.menu.element.MenuElement;

public class MenuElementAdapter implements IMenuItem {

    private MenuElement menuElement;

    public MenuElementAdapter(MenuElement menuElement) {
        this.menuElement = menuElement;
    }

    @Override
    public void setOnSelect(IHandler handler) {

    }

    @Override
    public void setText(String text) {

    }

    public MenuElement getProvidedObject()
    {
        return menuElement;
    }
}
