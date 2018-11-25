package com.pacgame.game.adapter;

import com.pacgame.Layer;
import com.pacgame.View;
import com.pacgame.game.ILayer;
import com.pacgame.game.IView;

public abstract class LayerAdapter implements ILayer {

    protected Layer layer;

    @Override
    public void addElement(IView view) {
        layer.addChildren(((View) view));
    }

    @Override
    public void removeElement(IView view) {

    }

    Layer getProvidedObject()
    {
        return layer;
    }
}
