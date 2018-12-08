package com.pacgame.uiElement;

import com.pacgame.Layer;
import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.PositionAlignmentProvider;

public abstract class ViewElement extends Layer {

    protected PositionAlignmentProvider positionAlignmentProvider;

    public ViewElement(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider) {
        super(provider);
        this.positionAlignmentProvider = positionAlignmentProvider;
    }

    public ViewElement(int width, int height, LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider) {
        super(width, height, provider);
        this.positionAlignmentProvider = positionAlignmentProvider;
    }
}
