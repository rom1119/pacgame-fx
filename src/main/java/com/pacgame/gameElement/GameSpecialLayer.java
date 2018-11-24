package com.pacgame.gameElement;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvider;

public abstract class GameSpecialLayer extends Layer {
    public GameSpecialLayer(LayerProvider layerProvider) {
        super(layerProvider);
    }

    public GameSpecialLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
    }
}
