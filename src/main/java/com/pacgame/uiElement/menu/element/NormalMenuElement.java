package com.pacgame.uiElement.menu.element;

import com.pacgame.provider.PaintProvider;
import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MenuElement;

public class NormalMenuElement extends MenuElement {
    public NormalMenuElement(UIProvider provider, PositionAlignmentProvider positionAlignmentProvider, PaintProvider paintProvider, String text) {
        super(provider, positionAlignmentProvider, text);
        getProvidedObject().setPadding(0, 20);
        getProvidedObject().setBorder(paintProvider.createYellow(), 5);

    }
}
