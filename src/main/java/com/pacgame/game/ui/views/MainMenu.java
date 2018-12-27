package com.pacgame.game.ui.views;

import com.pacgame.game.*;

public abstract class MainMenu extends Menu {


    public MainMenu(IMenuFactory menuFactory) {
        super(menuFactory);
    }

    public abstract void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory, ILayer root);
}
