package com.pacgame.game.ui.model;


import com.pacgame.game.IMenu;
import com.pacgame.game.IMenuItem;
import com.pacgame.game.IView;

public abstract class Menu
{
    protected IMenu menu;
//    protected Set<IMenuItem> menuItems;

    public Menu(IMenu menu) {
        this.menu = menu;
//        menuItems = new HashSet<>();
    }

    public IView getMenuElement() {
        return menu;
    }

    public void addMenuItem(IMenuItem menuItem)
    {
//        this.menuItems.add(menuItem);
        menu.addMenuItem(menuItem);
    }

    public void  removeMenuItem(IMenuItem menuItem)
    {
        menu.removeMenuItem(menuItem);
    }

    public void hide()
    {
        menu.hide();
    }
}
