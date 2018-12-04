package com.pacgame.uiElement;

import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.uiElement.menu.MainMenu;
import com.pacgame.uiElement.menu.Menu;
import com.pacgame.uiElement.menu.MenuElement;
import com.pacgame.uiElement.menu.element.NormalMenuElement;

public class MenuFactory {

    private UIProvider uiProvider;
    private LayerProvider layerProvider;
    private AlignmentProvider alignmentProvider;

    public MenuFactory(UIProvider uiProvider, LayerProvider layerProvider, AlignmentProvider alignmentProvider) {
        this.uiProvider = uiProvider;
        this.layerProvider = layerProvider;
        this.alignmentProvider = alignmentProvider;
    }

    public Menu createMenu(int width, int height) {
        return new MainMenu(layerProvider, alignmentProvider, width, height);
    }

    public MenuElement createMenuElement(String text) {
        return new NormalMenuElement(uiProvider, alignmentProvider, text) {
        };
    }
}
