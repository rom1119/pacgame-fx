package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;

public class VerticalLayer extends Layer {
    public VerticalLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.id = provider.createVerticalLayer();

    }

    public VerticalLayer(LayerProvider provider) {
        super(provider);
        this.id = provider.createVerticalLayer();

    }
}
