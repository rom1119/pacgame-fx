package com.pacgame.game;

import com.pacgame.game.event.AppEventFacade;
import com.pacgame.game.event.AppEventFacadeImpl;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.event.ui.UIEventFacade;

public class EventFacadeImpl implements IEventFacade {

    private UIEventFacade uiEventFacade;
    private BoardEventFacade boardEventFacade;
    private AppEventFacade appEventFacade;

    public EventFacadeImpl() {
        appEventFacade = new AppEventFacadeImpl();
    }

    @Override
    public UIEventFacade uiEventFacade() {
        return null;
    }

    @Override
    public BoardEventFacade boardEventFacade() {
        return null;
    }

    @Override
    public AppEventFacade appEventFacade() {
        return appEventFacade;
    }
}
