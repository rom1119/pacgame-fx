package com.pacgame.uiElement.menu;

import com.pacgame.provider.*;
import com.pacgame.provider.layer.VerticalLayer;

public class MainMenu extends Menu {

    protected VerticalLayer providedObject;

    public MainMenu(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider, int width, int height) {
        super(provider, positionAlignmentProvider, width, height);
        providedObject = provider.createVerticalLayer();
        providedObject.setWidth(width);
        providedObject.setHeight(width);
        providedObject.setAlignment(positionAlignmentProvider.topCenter());
    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }
}
