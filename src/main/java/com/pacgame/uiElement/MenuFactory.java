package com.pacgame.uiElement;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.PositionAlignmentProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;

public class MenuFactory {

    private UIProvider uiProvider;
    private LayerProvider layerProvider;
    private PositionAlignmentProvider positionAlignmentProvider;

    public MenuFactory(UIProvider uiProvider, LayerProvider layerProvider, PositionAlignmentProvider positionAlignmentProvider) {
        this.uiProvider = uiProvider;
        this.layerProvider = layerProvider;
        this.positionAlignmentProvider = positionAlignmentProvider;
    }

    public Menu createMenu(int width, int height) {
        return new MainMenu(layerProvider, positionAlignmentProvider, width, height);
    }

    public MenuElement createMenuElement(String text) {
        return new NormalMenuElement(uiProvider, positionAlignmentProvider, text) {
        };
    }
}
