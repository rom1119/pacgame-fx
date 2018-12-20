package com.pacgame.game;

import com.pacgame.game.event.ui.UIEventHandler;

public interface IMenuItem {

    void setOnSelect(UIEventHandler handler);
    void setText(String text);
}
