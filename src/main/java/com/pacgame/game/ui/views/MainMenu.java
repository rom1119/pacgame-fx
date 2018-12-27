package com.pacgame.game.ui.views;

import com.pacgame.event.EventFacade;
import com.pacgame.game.*;

public abstract class MainMenu extends Menu {

    protected IEventFacade eventFacade;

    public MainMenu(IMenuFactory menuFactory, IEventFacade eventFacade) {
        super(menuFactory);
        this.eventFacade = eventFacade;

    }

    public abstract void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory, ILayer root);
}
