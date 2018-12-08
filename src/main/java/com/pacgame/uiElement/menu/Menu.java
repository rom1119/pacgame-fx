package com.pacgame.uiElement.menu;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.uiElement.ViewElement;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends ViewElement {

    protected Map<String, MenuElement> menuItems;

    public Menu(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider, int width, int height) {
        super(width, height, provider, positionAlignmentProvider);
        menuItems = new HashMap<>();
    }

    @Override
    protected abstract LayerProvidedObject getProvidedObject();


    public void addMenuItem(MenuElement menuElement)
    {
        menuItems.put(menuElement.toString(), menuElement);
        getProvidedObject().addChildren(menuElement.getProvidedObject());
        menuElement.setMenu(this);
    }

    public void removeMenuItem(MenuElement menuElement)
    {
        menuItems.remove(menuElement.toString());
        getProvidedObject().removeChildren(menuElement.getProvidedObject());

    }


}

