package com.pacgame.uiElement;

import com.pacgame.provider.*;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;

public class MenuFactory {

    private final EventProvider eventProvider;
    private UIProvider uiProvider;
    private LayerProvider layerProvider;
    private PositionAlignmentProvider positionAlignmentProvider;
    private PaintProvider paintProvider;

    public MenuFactory(UIProvider uiProvider, LayerProvider layerProvider, PositionAlignmentProvider positionAlignmentProvider, PaintProvider paintProvider, EventProvider eventProvider) {
        this.uiProvider = uiProvider;
        this.layerProvider = layerProvider;
        this.positionAlignmentProvider = positionAlignmentProvider;
        this.paintProvider = paintProvider;
        this.eventProvider = eventProvider;
    }

    public Menu createMenu(int width, int height) {
        return new MainMenu(layerProvider, positionAlignmentProvider, eventProvider, paintProvider, width, height);
    }

    public MenuElement createMenuElement(String text) {
        NormalMenuElement normalMenuElement = new NormalMenuElement(uiProvider, positionAlignmentProvider, paintProvider, text);

        return normalMenuElement;
    }
}
