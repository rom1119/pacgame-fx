package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;

public class VerticalLayer extends Layer {
    public VerticalLayer(int width, int height, LayerProvidedObject providedObject) {
        super(width, height, providedObject);
    }

    public VerticalLayer(LayerProvidedObject providedObject) {
        super(providedObject);
    }
}
