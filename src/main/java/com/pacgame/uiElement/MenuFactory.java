package com.pacgame.uiElement;

import com.pacgame.provider.*;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;

public class MenuFactory {

    private UIProvider uiProvider;
    private LayerProvider layerProvider;
    private PositionAlignmentProvider positionAlignmentProvider;
    private PaintProvider paintProvider;

    public MenuFactory(UIProvider uiProvider, LayerProvider layerProvider, PositionAlignmentProvider positionAlignmentProvider, PaintProvider paintProvider) {
        this.uiProvider = uiProvider;
        this.layerProvider = layerProvider;
        this.positionAlignmentProvider = positionAlignmentProvider;
        this.paintProvider = paintProvider;
    }

    public Menu createMenu(int width, int height) {
        return new MainMenu(layerProvider, positionAlignmentProvider, width, height);
    }

    public MenuElement createMenuElement(String text) {
        NormalMenuElement normalMenuElement = new NormalMenuElement(uiProvider, positionAlignmentProvider, paintProvider, text);

        return normalMenuElement;
    }
}
