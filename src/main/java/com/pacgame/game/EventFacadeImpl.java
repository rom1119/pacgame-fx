package com.pacgame.game;

import com.pacgame.game.event.AppEventFacade;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.event.ui.UIEventFacade;

public class EventFacadeImpl implements IEventFacade {
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
        return null;
    }
}
