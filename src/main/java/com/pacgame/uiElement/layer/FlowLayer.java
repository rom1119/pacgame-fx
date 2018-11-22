package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;

public class FlowLayer extends Layer {
    public FlowLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject = provider.createFlowLayer();    }

    public FlowLayer(LayerProvider provider) {
        super(provider);
        this.providedObject = provider.createFlowLayer();
    }
}
