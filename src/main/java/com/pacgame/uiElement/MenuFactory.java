package com.pacgame.uiElement;

import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.element.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;
import com.pacgame.uiElement.text.Label;
import com.pacgame.uiElement.text.Text;

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
