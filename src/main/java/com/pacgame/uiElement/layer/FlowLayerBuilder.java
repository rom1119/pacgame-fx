package com.pacgame.uiElement.layer;

import com.pacgame.View;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.uiElement.ILayerBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FlowLayerBuilder implements ILayerBuilder<FlowLayer> {

    private FlowLayer buildedEl;
    private String name;
    private ColorProvidedObject color;
    private LayerProvider layerProvider;

    public FlowLayerBuilder(LayerProvider layerProvider) {
        this.layerProvider = layerProvider;
    }

    @Override
    public FlowLayer build() {
        this.buildedEl = new FlowLayer(layerProvider);

        return buildedEl;
    }

    @Override
    public FlowLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public FlowLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public FlowLayerBuilder addChildren(View el) {
        buildedEl.addChildren(el);
        return this;
    }

    @Override
    public ILayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }

}
