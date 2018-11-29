package com.pacgame.game.adapter;

import com.pacgame.View;
import com.pacgame.game.IView;

public abstract class ViewAdapter implements IView {
    public abstract View getProvidedObject();
}
