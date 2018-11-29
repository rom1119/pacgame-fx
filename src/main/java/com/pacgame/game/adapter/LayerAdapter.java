package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.View;
import com.pacgame.game.ILayer;
import com.pacgame.game.IView;

public abstract class LayerAdapter implements ILayer {
    protected Layer layer;

    @Override
    public void hide() {
        layer.hide();
    }

    @Override
    public void show() {
        layer.show();
    }


    @Override
    public void addElement(IView view) {
        layer.addChildren(((ViewAdapter) view).getProvidedObject());
    }

    @Override
    public void removeElement(IView view) {

    }

    public Layer getProvidedObject()
    {
        return layer;
    }

    @Override
    public int getWidth() {
        return layer.getWidth();
    }

    @Override
    public int getHeight() {
        return layer.getHeight();
    }

    @Override
    public void setWidth(int width) {
        layer.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        layer.setHeight(height);
    }
}
