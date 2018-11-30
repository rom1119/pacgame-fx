package com.pacgame.uiElement;

import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;

public class MenuFactory {

    private UIProvider uiProvider;
    private LayerProvider layerProvider;

    public MenuFactory(UIProvider uiProvider, LayerProvider layerProvider) {
        this.uiProvider = uiProvider;
        this.layerProvider = layerProvider;
    }

    public Menu createMenu(int width, int height) {
        return new MainMenu(layerProvider, width, height);
    }

    public MenuElement createMenuElement(String text) {
        return new NormalMenuElement(uiProvider, text) {
        };
    }
}
