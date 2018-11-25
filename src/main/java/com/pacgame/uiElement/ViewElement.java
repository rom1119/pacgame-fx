package com.pacgame.uiElement;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvider;

public abstract class ViewElement extends Layer {
    public ViewElement(LayerProvider provider) {
        super(provider);
    }

    public ViewElement(int width, int height, LayerProvider provider) {
        super(width, height, provider);
    }
}
