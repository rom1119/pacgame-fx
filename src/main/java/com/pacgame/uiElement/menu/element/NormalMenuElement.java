package com.pacgame.uiElement.menu.element;

import com.pacgame.provider.EventProvider;
import com.pacgame.provider.PaintProvider;
import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MenuElement;

public class NormalMenuElement extends MenuElement {
    public static final int BORDER_WIDTH = 5;
    private PaintProvider paintProvider;

    public NormalMenuElement(UIProvider provider, PositionAlignmentProvider positionAlignmentProvider, PaintProvider paintProvider, EventProvider eventProvider, String text) {
        super(provider, positionAlignmentProvider, eventProvider, text);
        this.paintProvider = paintProvider;
        getProvidedObject().setPadding(0, 20);
        getProvidedObject().setBorder(paintProvider.createCustom(0, 0, 0, 0), BORDER_WIDTH);

    }

    @Override
    public void check() {
        getProvidedObject().setBorder(paintProvider.createGreen(), NormalMenuElement.BORDER_WIDTH);
    }

    @Override
    public void unCheck() {
        getProvidedObject().setBorder(paintProvider.createCustom(0, 0, 0, 0), BORDER_WIDTH);
    }
}
