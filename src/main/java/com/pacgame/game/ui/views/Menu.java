package com.pacgame.game.ui.views;


import com.pacgame.game.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Menu
{
    private int width = 100;
    private int height = 100;
    protected IMenu menu;
    protected Set<IMenuItem> menuItems;
    protected IMenuFactory menuFactory;


    public Menu(IMenuFactory menuFactory) {
        this.menuFactory = menuFactory;
        this.menu = menuFactory.createMenu(width, height);
        menuItems = new HashSet<>();
    }

    public IView getMenuElement() {
        return menu;
    }

    public IMenuItem addMenuItem(String text)
    {
        IMenuItem menuItem = menuFactory.createMenuItem(text);
        this.menuItems.add(menuItem);
        menu.addMenuItem(menuItem);

        return menuItem;
    }

    public void setColor(IColor color)
    {
        this.menu.setBackground(color);
    }

    public void removeMenuItem(IMenuItem menuItem)
    {
        menuItems.remove(menuItem);
        menu.removeMenuItem(menuItem);
    }

    public void hide()
    {
        menu.hide();
    }
    public void show()
    {
        menu.show();
    }

    public void setWidth(int width)
    {
        this.width = width;
        menu.setWidth(width);
        menuItems.forEach(e -> {
            e.setWidth(width);
        });
    }

    public void setHeight(int height)
    {
        this.height = height;
        menu.setHeight(height);
        menuItems.forEach(e -> {
            e.setHeight(height);
        });
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
