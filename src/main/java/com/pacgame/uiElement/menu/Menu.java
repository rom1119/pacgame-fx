package com.pacgame.uiElement.menu;

import com.pacgame.provider.*;
import com.pacgame.uiElement.ViewElement;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends ViewElement {

    protected final EventProvider eventProvider;
    protected PaintProvider paintProvider;
    protected Map<String, MenuElement> menuItems;

    public Menu(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider, EventProvider eventProvider, PaintProvider paintProvider, int width, int height) {
        super(width, height, provider, positionAlignmentProvider);
        this.eventProvider = eventProvider;
        menuItems = new HashMap<>();
        this.paintProvider = paintProvider;
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

    protected abstract void setOnCheckedMenuItem();


}

