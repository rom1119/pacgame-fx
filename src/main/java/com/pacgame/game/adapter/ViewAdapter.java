package com.pacgame.game.adapter;

import com.pacgame.View;
import com.pacgame.game.IColor;
import com.pacgame.game.IView;

public abstract class ViewAdapter implements IView {
    public abstract View getProvidedObject();

    @Override
    public void hide() {
        getProvidedObject().hide();
    }

    @Override
    public void show() {
        getProvidedObject().show();
    }

    @Override
    public void setBackground(IColor color) {
        getProvidedObject().setBackground(((ColorAdapter)color).getValue());
    }

    @Override
    public void setX(int x) {
        getProvidedObject().setX(x);
    }

    @Override
    public void setY(int y) {
        getProvidedObject().setY(y);
    }

    @Override
    public boolean isVisible() {
        return getProvidedObject().isVisible();
    }
}
