package com.pacgame.game;

import com.pacgame.game.event.AppEventFacade;
import com.pacgame.game.event.board.BoardEventFacade;
import com.pacgame.game.event.ui.UIEventFacade;

public interface IEventFacade {


    UIEventFacade uiEventFacade();

    BoardEventFacade boardEventFacade();

    AppEventFacade appEventFacade();
}
