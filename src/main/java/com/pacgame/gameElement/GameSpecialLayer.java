package com.pacgame.gameElement;

import com.pacgame.Layer;
import com.pacgame.provider.ILayerProvider;

public abstract class GameSpecialLayer extends Layer {
    public GameSpecialLayer(ILayerProvider layerProvider) {
        super(layerProvider);
    }
}
