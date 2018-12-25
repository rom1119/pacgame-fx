package com.pacgame.game.ui.views;


import com.pacgame.game.IColor;
import com.pacgame.game.IMenu;
import com.pacgame.game.IMenuItem;
import com.pacgame.game.IView;

import java.util.HashSet;
import java.util.Set;

public abstract class Menu
{
    protected IMenu menu;
    protected Set<IMenuItem> menuItems;

    public Menu(IMenu menu) {
        this.menu = menu;
        menuItems = new HashSet<>();
    }

    public IView getMenuElement() {
        return menu;
    }

    public void addMenuItem(IMenuItem menuItem)
    {
        this.menuItems.add(menuItem);
        menu.addMenuItem(menuItem);
    }

    public void setColor(IColor color)
    {
        this.menu.setBackground(color);
    }

    public void  removeMenuItem(IMenuItem menuItem)
    {
        menuItems.remove(menuItem);
        menu.removeMenuItem(menuItem);
    }

    public void hide()
    {
        menu.hide();
    }
}
