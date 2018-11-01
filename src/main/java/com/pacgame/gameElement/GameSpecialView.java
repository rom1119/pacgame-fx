package com.pacgame.gameElement;

import com.pacgame.View;
import com.pacgame.provider.ILayerProvider;

public abstract class GameSpecialView extends View {
    public GameSpecialView(ILayerProvider layerProvider) {
        super(layerProvider);
    }
}
