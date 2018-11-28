package com.pacgame.game.adapter.factory;

import com.pacgame.game.IMenu;
import com.pacgame.game.IMenuFactory;
import com.pacgame.game.IMenuItem;
import com.pacgame.game.adapter.MenuAdapter;
import com.pacgame.game.adapter.MenuElementAdapter;
import com.pacgame.uiElement.MenuFactory;

public class MenuFactoryAdapter implements IMenuFactory {

    private MenuFactory menuFactory;

    public MenuFactoryAdapter(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }

    @Override
    public IMenu createMenu(int width, int height) {
        return new MenuAdapter(menuFactory.createMenu(width, height));
    }

    @Override
    public IMenuItem createMenuItem(String text) {
        return new MenuElementAdapter(menuFactory.createMenuElement(text));
    }
}
