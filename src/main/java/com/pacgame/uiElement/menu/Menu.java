package com.pacgame.uiElement.menu;

import com.pacgame.uiElement.UIElement;
import com.pacgame.uiElement.menu.element.MenuElement;

import java.util.HashSet;
import java.util.Set;

public abstract class Menu extends UIElement {

    protected Map<MenuElement> menuItems;

    public Menu(int width, int height) {
        super(width, height);
        menuItems = new HashSet<>();
    }

    public void addMenuItem(MenuElement menuElement)
    {
        menuItems.add(menuElement);
    }

    public void removeMenuItem(MenuElement menuElement)
    {
        menuItems.remove(menuElement);
    }
}

