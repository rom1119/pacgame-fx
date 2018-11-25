package com.pacgame.uiElement.menu;

import com.pacgame.View;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.UIElement;
import com.pacgame.uiElement.ViewElement;
import com.pacgame.uiElement.menu.element.MenuElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Menu extends ViewElement {

    protected Map<String, MenuElement> menuItems;
    protected LayerProvidedObject providedObject;

    public Menu(LayerProvider provider, int width, int height) {
        super(width, height, provider);
        providedObject = provider.createVerticalLayer();
        providedObject.setWidth(width);
        providedObject.setHeight(width);
        menuItems = new HashMap<>();
    }

    public void addMenuItem(MenuElement menuElement)
    {
        menuItems.put(menuElement.toString(), menuElement);
    }

    public void removeMenuItem(MenuElement menuElement)
    {
        menuItems.remove(menuElement.toString());
    }
}

