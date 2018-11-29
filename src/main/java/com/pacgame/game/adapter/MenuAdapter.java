package com.pacgame.game.adapter;

import com.pacgame.game.IHandler;
import com.pacgame.game.IMenu;
import com.pacgame.game.IMenuItem;
import com.pacgame.uiElement.MenuFactory;
import com.pacgame.uiElement.menu.Menu;

public class MenuAdapter extends ViewAdapter implements IMenu {

    private Menu menu;

    public MenuAdapter(Menu menu) {
        this.menu = menu;
    }



    @Override
    public void addMenuItem(IMenuItem item) {
        this.menu.addMenuItem(((MenuElementAdapter) item).getProvidedObject());
    }


    @Override
    public void removeMenuItem(IMenuItem item) {
        this.menu.removeMenuItem(((MenuElementAdapter) item).getProvidedObject());
    }

    @Override
    public void setWidth(int width) {
        menu.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        menu.setHeight(height);
    }

    public Menu getProvidedObject()
    {
        return menu;
    }


    @Override
    public void hide() {
        menu.hide();
    }

    @Override
    public void show() {
        menu.show();
    }
}
