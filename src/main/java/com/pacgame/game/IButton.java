package com.pacgame.game;

import com.pacgame.game.event.ui.ButtonAction;
import com.pacgame.game.event.ui.UIEventHandler;

public interface IButton extends IUIComponent {

    void setOnAction(UIEventHandler<ButtonAction> handler);
}
