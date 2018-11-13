package com.pacgame.uiElement.layer;

import com.pacgame.View;
import com.pacgame.provider.ILayerProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.Color;
import com.pacgame.uiElement.ILayerBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class VerticalLayerBuilder implements ILayerBuilder<VerticalLayer> {

    private VerticalLayer buildedEl;
    private String name;
    private Color color;

    private ILayerProvider layerProvider;

    public VerticalLayerBuilder(ILayerProvider layerProvider) {
        this.layerProvider = layerProvider;
    }



    @Override
    public VerticalLayer build() {
        this.buildedEl = new VerticalLayer(layerProvider.verticalLayerBuilder().build());

        return buildedEl;
    }

    @Override
    public VerticalLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

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
    public VerticalLayerBuilder color(Color color) {
        this.color = color;

        return this;
    }
}
