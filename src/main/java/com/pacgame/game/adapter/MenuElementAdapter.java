package com.pacgame.game.adapter;

import com.pacgame.game.IHandler;
import com.pacgame.game.IMenuItem;
import com.pacgame.game.adapter.event.SelectMenuItemAdapter;
import com.pacgame.game.event.ui.SelectMenuItem;
import com.pacgame.game.event.ui.UIEventHandler;
import com.pacgame.uiElement.menu.MenuElement;

public class MenuElementAdapter implements IMenuItem {

    private MenuElement menuElement;

    public MenuElementAdapter(MenuElement menuElement) {
        this.menuElement = menuElement;
    }

    @Override
    public void setOnSelect(UIEventHandler<SelectMenuItem> handler) {

        SelectMenuItem selectMenuItemAdapter = new SelectMenuItemAdapter(this, this);
        getProvidedObject().setOnSelect(e -> {
            handler.handle(selectMenuItemAdapter);
        });
    }

    @Override
    public void setText(String text) {
        menuElement.setText(text);
    }

    @Override
    public void setWidth(int width) {
        menuElement.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        menuElement.setHeight(height);
    }

    public MenuElement getProvidedObject()
    {
        return menuElement;
    }
}
