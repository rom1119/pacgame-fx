package com.pacgame.uiElement;

import com.pacgame.Layer;
import com.pacgame.provider.AlignmentProvider;
import com.pacgame.provider.LayerProvider;

public abstract class ViewElement extends Layer {

    protected AlignmentProvider alignmentProvider;

    public ViewElement(LayerProvider provider, AlignmentProvider alignmentProvider) {
        super(provider);
        this.alignmentProvider = alignmentProvider;
    }

    public ViewElement(int width, int height, LayerProvider provider, AlignmentProvider alignmentProvider) {
        super(width, height, provider);
        this.alignmentProvider = alignmentProvider;
    }
}
