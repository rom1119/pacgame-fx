package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProvidedObject;

public class FlowLayerBuilder implements ILayerBuilder<FlowLayer> {

    private FlowLayer buildedEl;
    private String name;

    @Override
    public FlowLayer build() {
        this.buildedEl = new FlowLayer();

        return buildedEl;
    }

    @Override
    public ILayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);
        return null;
    }

    @Override
    public ILayerBuilder textElement() {
        return this;
    }

    public FlowLayerBuilder addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);
        return this;
    }

}
