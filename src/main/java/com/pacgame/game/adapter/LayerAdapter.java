package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.View;
import com.pacgame.game.IColor;
import com.pacgame.game.ILayer;
import com.pacgame.game.IView;

public abstract class LayerAdapter extends ViewAdapter implements ILayer {

    @Override
    public void addElement(IView view) {
        getProvidedObject().addChildren(((ViewAdapter) view).getProvidedObject());
    }

    @Override
    public void removeElement(IView view) {

    }

    public abstract Layer getProvidedObject();

    @Override
    public int getWidth() {
        return getProvidedObject().getWidth();
    }

    @Override
    public int getHeight() {
        return getProvidedObject().getHeight();
    }

    @Override
    public void setWidth(int width) {
        getProvidedObject().setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        getProvidedObject().setHeight(height);
    }
}
