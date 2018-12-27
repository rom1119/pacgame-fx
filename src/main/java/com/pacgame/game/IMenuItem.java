package com.pacgame.game;

import com.pacgame.game.event.Target;
import com.pacgame.game.event.ui.SelectMenuItem;
import com.pacgame.game.event.ui.UIEventHandler;

public interface IMenuItem extends Target {

    void setOnSelect(UIEventHandler<SelectMenuItem> handler);
    void setText(String text);

    void setWidth(int width);
    void setHeight(int height);
}
