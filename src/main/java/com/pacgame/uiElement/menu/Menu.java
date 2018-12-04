package com.pacgame.uiElement.menu;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.uiElement.ViewElement;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends ViewElement {

    protected Map<String, MenuElement> menuItems;
    protected LayerProvidedObject providedObject;

    public Menu(LayerProvider provider, AlignmentProvider alignmentProvider, int width, int height) {
        super(width, height, provider, alignmentProvider);
        providedObject = provider.createVerticalLayer();
        providedObject.setWidth(width);
        providedObject.setHeight(width);
        menuItems = new HashMap<>();
    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }


    public void addMenuItem(MenuElement menuElement)
    {
        menuItems.put(menuElement.toString(), menuElement);
        providedObject.addChildren(menuElement.getProvidedObject());
    }

    public void removeMenuItem(MenuElement menuElement)
    {
        menuItems.remove(menuElement.toString());
        providedObject.removeChildren(menuElement.getProvidedObject());

    }


}

