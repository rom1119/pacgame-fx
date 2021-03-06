package com.pacgame.uiElement.layer;

import com.pacgame.View;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.uiElement.ILayerBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class VerticalLayerBuilder implements ILayerBuilder<VerticalLayer> {

    private VerticalLayer buildedEl;
    private String name;
    private ColorProvidedObject color;
    private int width;
    private int height;

    private LayerProvider layerProvider;

    public VerticalLayerBuilder(LayerProvider layerProvider) {
        this.layerProvider = layerProvider;
    }



    @Override
    public VerticalLayer build() {
        this.buildedEl = new VerticalLayer(layerProvider);
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return buildedEl;
    }

    @Override
    public VerticalLayerBuilder with(int width, int height) {
        this.width = width;
        this.height = height;

        return this;
    }

    @Override
    public VerticalLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public VerticalLayerBuilder addChildren(View el) {
        buildedEl.addChildren(el);
        return this;
    }

    @Override
    public VerticalLayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }
}
